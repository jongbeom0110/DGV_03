package DGV;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class movieSQL {

    // DB연동 3객체
    Connection con;             // 접속
    PreparedStatement pstmt;    // SQL문
    ResultSet rs;               // 결과

    // DB접속 메소드
    public void connect() {
        con = DBC.DBConnect();
    }

    // DB해제 메소드
    public void conClose() {
        try {
            con.close();    // 접속한 DB를 닫다(close)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    TMember member = new TMember();
    Scanner sc = new Scanner(System.in);

    // 1. 회원가입 메소드
    public void TMember(TMember member) {
        try {
            // (1) sql문 작성 : 입력할 데이터 대신 '?' 작성
            String sql = "INSERT INTO TMEMBER VALUES(?, ?, ?, ?, ?)";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.gettId());        //아이디
            pstmt.setString(2, member.gettPw());        //비밀번호
            pstmt.setString(3, member.gettName());      //이름
            pstmt.setString(4, member.gettBirth());     //생년월일
            pstmt.setString(5, member.gettPhone());     //핸드폰번호

            int result = pstmt.executeUpdate();

            // (5) 결과처리
            if (result > 0) {
                System.out.println("가입 성공!");
            } else {
                System.out.println("가입 실패!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // 2. 로그인 메소드
    public boolean memberLogin(String tId, String tPw) {
        boolean result = false;

        try {
            String sql = "SELECT * FROM TMEMBER WHERE  TID=? AND TPW=?";

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, tId);        //아이디
            pstmt.setString(2, tPw);        //비밀번호

            rs = pstmt.executeQuery();

            result = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    // 2-1. (1) 영화 상영 목록 메소드 =====================================================================================
    public void infoMovie() {
        try {
            // CGV 영화 페이지 URL
            String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";

            // Jsoup을 사용하여 웹 페이지의 HTML 가져오기
            Document doc = Jsoup.connect(url).get();

            // 영화 목록이 있는 HTML 요소 선택
            Elements movieElements = doc.select("div.sect-movie-chart ol li");

            // 각 영화 정보에 대해 반복
            int movieCount = movieElements.size();
            for (int i = 0; i < movieCount; i++) {
                Element movieElement = movieElements.get(i);

                // 영화 제목과 개봉일 추출
                String title = movieElement.select("strong.title").text();
                String releaseDate = movieElement.select("span.txt-info").text();

                // 마지막 요소인지 확인
                boolean isLastMovie = (i == movieCount - 1);

                // 마지막 요소가 아닌 경우에만 출력
                if (!isLastMovie) {
                    System.out.println("순위: " + (i + 1) + "위 | 영화 제목: " + title + "  |  개봉일: " + releaseDate);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2-1. (2) 영화 해당 날짜의 영화 번호 메소드
    public void choice(String mdate, String member) {
        Scanner sc = new Scanner(System.in);
        try {
            // 영화 정보를 가져오는 쿼리 실행
            String sql = "SELECT *  FROM MOVIE WHERE MDATE = '24/03/' || ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mdate);

            // 쿼리 실행 및 결과 가져오기
            rs = pstmt.executeQuery();

            // 결과 출력을 위한 데이터 구조 초기화
            Map<Integer, String[]> movieDetails = new HashMap<>();
            boolean movies = false;
            while (rs.next()) {
                movies = true;
                int movieNum = rs.getInt("MNUM");
                String rName = rs.getString("MNAME");
                String rCinema = rs.getString("CINEMA");
                String rDate = rs.getString("MDATE");
                String rTime = rs.getString("MTIME");

                movieDetails.put(movieNum, new String[]{rName, rCinema, rDate, rTime});

                System.out.println();
                System.out.println("영화 번호: " + movieNum + " | 제목: " + rName + " | 상영관: " + rCinema);
                System.out.println("날짜: " + rDate + " | 상영 시간: " + rTime);
            }
            if (movies) {
                System.out.print("영화 번호를 선택하세요>> ");
                int movieNum = sc.nextInt();

                if (movieDetails.containsKey(movieNum)) {
                    String[] details = movieDetails.get(movieNum);
                    // 선택한 영화 번호가 유효한 경우, 좌석 선택 메서드 호출
                    selectSeat(movieNum, details, member);
                } else {
                    System.out.println("잘못된 영화 번호입니다.");
                }
            } else {
                System.out.println("선택한 날짜에 상영 영화가 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2-1. (3) 좌석 선택
    public void selectSeat(int movieNum, String[] movieDetails, String memberId) {
        try {
            int rcheck = checkNum();

            // 좌석 초기화 및 배치도 표시
            String rDate = movieDetails[2];
            if (checkReset(rDate, movieNum)) {
                resetSeats(rDate, movieNum);
            }
            displaySeats();

            // 좌석 선택 반복문
            while (true) {
                // 좌석 정보 입력 받기
                System.out.print("좌석 열(A, B, C, D, E)을 입력해주세요: ");
                String srow = sc.next().toUpperCase();
                System.out.print("좌석 행(1, 2, 3, 4, 5)을 입력해주세요: ");
                int scol = sc.nextInt();

                // 해당 좌석의 예약 상태 확인
                String sql = "SELECT STATUS FROM SEAT WHERE RDATE = ? AND SROW = ? AND SCOL = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, rDate);
                pstmt.setString(2, srow);
                pstmt.setInt(3, scol);
                rs = pstmt.executeQuery();

                // 이미 예약된 좌석인 경우 메시지 출력 후 반복
                if (rs.next() && "RESERVED".equals(rs.getString("STATUS"))) {
                    System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
                    System.out.println();
                    continue;
                }

                // SEAT 테이블에 좌석 정보 저장
                sql = "INSERT INTO SEAT (RCHECK, MNUM, RDATE, SROW, SCOL, STATUS) VALUES (?, ?, ?, ?, ?, 'RESERVED')";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, rcheck);
                pstmt.setInt(2, movieNum);
                pstmt.setString(3, rDate);
                pstmt.setString(4, srow);
                pstmt.setInt(5, scol);
                pstmt.executeUpdate();

                // 예약 정보 저장
                saveReserv(movieNum, rcheck, movieDetails[0], movieDetails[1], rDate, movieDetails[3], memberId);
                // 결제 진행
                Payment(memberId);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2-1. (4) 예약정보 저장
    public void saveReserv(int movieNum, int rcheck, String movieName, String cinema, String reservationDate, String reservationTime, String memberId) {
        try {
            // 현재 예약 테이블에서 최대 RNUM 조회
            String maxRnumSql = "SELECT MAX(RNUM) FROM RESERV";
            pstmt = con.prepareStatement(maxRnumSql);
            rs = pstmt.executeQuery();
            int maxRnum = 0;
            if (rs.next()) {
                maxRnum = rs.getInt(1);
            }
            int RNum = maxRnum + 1;

            String insertSql = "INSERT INTO RESERV (RNUM, TID, MNUM, RCHECK, MNAME, CINEMA, RDATE, RTIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(insertSql);

            pstmt.setInt(1, RNum);
            pstmt.setString(2, memberId);
            pstmt.setInt(3, movieNum);
            pstmt.setInt(4, rcheck);
            pstmt.setString(5, movieName);
            pstmt.setString(6, cinema);
            pstmt.setString(7, reservationDate);
            pstmt.setString(8, reservationTime);
            pstmt.executeUpdate();

            System.out.println("예약이 완료되었습니다. \n예약 번호: " + rcheck);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2-1. (5) 예약번호 자동생성
    public int checkNum() {
        int rnum = 0;

        for (int i = 0; i < 6; i++) {
            rnum *= 10;
            rnum += (int) (Math.random() * 10);
        }
        return rnum;
    }

    // 2-1. (6)  좌석 예약 유무
    private boolean checkReset(String rDate, int movieNum) throws SQLException {
        // 현재 날짜와 영화 번호에 대해 이미 예약된 좌석이 있는지 확인
        String sql = "SELECT COUNT(*) FROM SEAT WHERE RDATE = ? AND MNUM = ? AND STATUS = 'RESERVED'";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, rDate);
            pstmt.setInt(2, movieNum);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // 이미 예약된 좌석이 없으면 true 반환 (초기화 필요)
                return rs.getInt(1) == 0;
            }
        }
        return false; // 기본적으로는 초기화하지 않음
    }

    // 2-1. (7) 다른 날짜 다른 영화 좌석 초기화
    private void resetSeats(String rDate, int movieNum) throws SQLException {
        try {
            // 해당 날짜와 영화를 제외한 모든 좌석 초기화
            String sql = "UPDATE SEAT SET STATUS = 'EMPTY' WHERE (RDATE != ? OR MNUM != ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, rDate);
                pstmt.setInt(2, movieNum);
                pstmt.executeUpdate();
            }

            // 선택된 날짜와 영화의 좌석만 초기화하지 않음
            sql = "UPDATE SEAT SET STATUS = 'RESERVED' WHERE RDATE = ? AND MNUM = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, rDate);
                pstmt.setInt(2, movieNum);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 2-1. (8) 좌석배치도
    private void displaySeats() throws SQLException {
        try {
            String sql = "SELECT * FROM SEAT";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            char[][] seats = new char[5][5];
            //좌석 배열 초기화
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    seats[i][j] = '□';  // 초기값 설정
                }
            }

            String[] AA = {
                    "A", "B", "C", "D", "E"
            };
            // 데이터베이스에서 좌석 상태 읽어와서 배열에 반영
            while (rs.next()) {
                String srow = rs.getString("SROW");
                int scol = rs.getInt("SCOL");
                String status = rs.getString("STATUS");

                int row = srow.charAt(0) - 'A';  // 'A' -> 0, 'B' -> 1, ...
                int col = scol - 1;               // 1 -> 0, 2 -> 1, ...

                if ("RESERVED".equals(status)) {
                    seats[row][col] = '■';  // 예약된 좌석 표시
                }
            }
            // 좌석 배치도 출력
            System.out.println("┌────────────┐");
            System.out.println("|    스크린   |");
            System.out.println("└────────────┘");
            System.out.println("  1 2 3 4 5 ");
            for (int i = 0; i < 5; i++) {
                System.out.print(AA[i] + " ");
                for (int j = 0; j < 5; j++) {

                    System.out.print(seats[i][j] + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // 예외를 다시 throw하여 상위 메서드로 전달
        }
    }

    // 2-1. (9) 결제하기
    public void Payment(String memberId) throws SQLException {
        // 고객의 생년월일 조회
        String birthSql = "SELECT TBIRTH, TPHONE FROM TMEMBER WHERE TID = ?";
        pstmt = con.prepareStatement(birthSql);
        pstmt.setString(1, memberId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            String birthStr = rs.getString("TBIRTH");
            String tphone = rs.getString("TPHONE");
            int birthYear = Integer.parseInt(birthStr.substring(0, 4));

            // 미성년자인지 여부에 따라 요금 설정
            int price = (birthYear > 2005) ? 10000 : 15000;

            // 결제 정보 출력 및 핸드폰 결제 진행
            System.out.println();
            System.out.println("결제 요금: " + price + "원");
            System.out.println("결제를 진행 하겠습니다. 핸드폰 번호를 입력하세요:");
            String phoneNumber = sc.next();

            if(Objects.equals(tphone, phoneNumber)){
                System.out.println("핸드폰 결제가 완료되었습니다.");
            }else{
            System.out.println("아이디와 일치하지 않는 번호입니다.");
            }
        } else {
            System.out.println("고객의 생년월일을 찾을 수 없습니다.");
        }
    }

    // 2-2. 예매 조회
    public void ListCheckCode() throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("예매번호를 입력해주세요: ");
            int rcheck = sc.nextInt();

            String sql = "SELECT R.TID, R.MNAME, R.CINEMA, R.RDATE, R.RTIME, S.SROW, S.SCOL " +
                    "FROM RESERV R " +
                    "INNER JOIN SEAT S ON R.RCHECK = S.RCHECK " +
                    "WHERE R.RCHECK = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, rcheck);

            rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                String tid = rs.getString("TID");
                String movieName = rs.getString("MNAME");
                String cinema = rs.getString("CINEMA");
                String date = rs.getString("RDATE");
                String time = rs.getString("RTIME");
                String seatRow = rs.getString("SROW");
                int seatCol = rs.getInt("SCOL");

                System.out.println("회원 ID : " + tid);
                System.out.println("예매번호 : " + rcheck);
                System.out.println("영화이름 : " + movieName);
                System.out.println("상영관 : " + cinema);
                System.out.println("날짜 : " + date);
                System.out.println("시간 : " + time);
                System.out.println("좌석 : " + seatRow + seatCol);
                System.out.println();
            }
            if (!found) {
                System.out.println("예매번호 [" + rcheck + "]에 해당하는 예약 정보가 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ListCheckId() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("ID를 입력해주세요. ");
            String idcheck = sc.nextLine();

            String sql = "SELECT R.*, S.* FROM RESERV R JOIN SEAT S ON R.RCHECK = S.RCHECK WHERE R.TID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, idcheck);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                // 필요한 예약 정보 출력
                System.out.println("회원 ID : " + idcheck);
                System.out.println("예매번호 : " + rs.getInt("RCHECK"));
                System.out.println("영화이름 : " + rs.getString("MNAME"));
                System.out.println("상영관 : " + rs.getString("CINEMA"));
                System.out.println("날짜 : " + rs.getString("RDATE"));
                System.out.println("시간 : " + rs.getString("RTIME"));
                // 좌석 정보 출력
                System.out.println("좌석 : " + rs.getString("SROW") + rs.getInt("SCOL"));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 2-3. 예매 취소
    public void cancel() throws SQLException {
        try {
            System.out.print("예약을 취소할 예약 번호를 입력하세요: ");
            int rcheck = sc.nextInt();

            // 해당 예약 번호로 예약된 좌석을 모두 취소
            String sql = "DELETE FROM SEAT WHERE RCHECK = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, rcheck);
                pstmt.executeUpdate();
            }

            // 예약 번호를 통해 RESERV 테이블에서 해당 예약 삭제
            sql = "DELETE FROM RESERV WHERE RCHECK = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, rcheck);
                pstmt.executeUpdate();
            }

            System.out.println("예약이 취소되었습니다.");
            System.out.println("결제된 금액은 3~5일 내로 취소됩니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 2-4. 회원 수정 메소드
    public void memberModify(TMember member) {
        try {
            // (1) sql문 작성 : 입력할 데이터 대신 '?' 작성
            String sql = "UPDATE TMEMBER SET TPW=?, TNAME=?, TBIRTH=?, TPHONE=? WHERE TID=?";

            // (2) db 준비
            pstmt = con.prepareStatement(sql);

            // (3) sql문에서 '?' 데이터 처리
            // 수정할 컬럼들
            pstmt.setString(1, member.gettPw());        //비밀번호
            pstmt.setString(2, member.gettName());      //이름
            pstmt.setString(3, member.gettBirth());     //생년월일
            pstmt.setString(4, member.gettPhone());     //핸드폰 번호

            // 기준이 되는 컬럼 TID가 5번째 '?'
            pstmt.setString(5, member.gettId());

            // (4) 실행 : insert, update, delete(int result), select(ResultSet rs)
            int result = pstmt.executeUpdate();

            // (5) 결과처리
            if (result > 0) {
                System.out.println("수정 성공!");
            } else {
                System.out.println("수정 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 2-5. 회원 삭제 메소드
    public void memberDelete(String tId) {

        try {
            // (1) sql문 작성 : 입력할 데이터 대신 '?' 작성
            String sql = "DELETE FROM TMEMBER WHERE TID=?";

            // (2) db 준비
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, tId);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("삭제 성공!");
            } else {
                System.out.println("삭제 실패!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}








