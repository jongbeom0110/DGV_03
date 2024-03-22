package DGV;

import java.sql.SQLException;
import java.util.Scanner;

public class movieMain {
    public static void main(String[] args) throws SQLException {
        //객체
        TMember member = new TMember();
        movieSQL sql = new movieSQL();
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        int menu = 0;

        boolean run1 = true;
        int menu1 = 0;

        sql.connect();

        while (run) {

            Util.Logo();

            System.out.println("========================  DGV  ========================");
            System.out.println("         [1]회원가입       [2] 로그인      [3] 종료        ");
            System.out.println("=======================================================");
            System.out.print("메뉴 선택 >> ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println();
                    System.out.println("회원정보를 입력해주세요");

                    System.out.print("아이디 >> ");
                    String tId = sc.next();

                    System.out.print("비밀번호 >> ");
                    String tPw = sc.next();

                    System.out.print("이름 >> ");
                    String tName = sc.next();

                    System.out.print("생년월일 >> ");
                    String tBirth = sc.next();

                    System.out.print("전화번호 >> ");
                    String tPhone = sc.next();

                    member.settId(tId);
                    member.settPw(tPw);
                    member.settName(tName);
                    member.settBirth(tBirth);
                    member.settPhone(tPhone);

                    sql.TMember(member);

                    break;

                case 2:
                    System.out.print("아이디 >> ");
                    tId = sc.next();
                    System.out.print("비밀번호 >> ");
                    tPw = sc.next();

                    boolean login = sql.memberLogin(tId, tPw);

                    if (login) {
                        System.out.println("로그인 성공");
                        run1 = true;

                        while (run1) {
                            System.out.println("=========================  DGV  ========================");
                            System.out.println("         [1]예매하기    [2] 예매조회    [3] 예매취소          ");
                            System.out.println("         [4]회원수정    [5] 회원삭제    [6] 로그아웃         ");
                            System.out.println("=========================================================");
                            System.out.print("메뉴 선택 >> ");
                            menu1 = sc.nextInt();

                            switch (menu1) {
                                case 1:
                                    sql.infoMovie(); //상영 영화 정보
                                    Calendar.calender(); //달력

                                    System.out.print("날짜 선택 >> ");
                                    String dNum = null;
                                    dNum = sc.next();
                                    if (dNum.length() == 1) {
                                        dNum = "0" + dNum;
                                    }
                                    sql.choice(dNum, tId);

                                    break;
                                case 2:
                                    System.out.println("=================================");
                                    System.out.println("  [1]예매번호 조회    [2]아이디 조회  ");
                                    System.out.println("=================================");
                                    int menu2 = sc.nextInt();

                                    switch (menu2){
                                        case 1 :
                                            sql.ListCheckCode();
                                            break;
                                        case 2 :
                                            sql.ListCheckId();
                                            break;
                                        default:
                                            break;
                                    }


                                    break;

                                case 3:
                                    sql.cancel();
                                    break;

                                case 4:
                                    System.out.println("수정할 정보를 입력해주세요!");

                                    System.out.print("비밀번호 >> ");
                                    tPw = sc.next();

                                    System.out.print("이름 >> ");
                                    tName = sc.next();

                                    System.out.print("생년월일 >> ");
                                    tBirth = sc.next();

                                    System.out.print("연락처 >> ");
                                    tPhone = sc.next();

                                    // 입력받은 정보를 member객체에 담는다
                                    member.settId(tId);
                                    member.settPw(tPw);
                                    member.settName(tName);
                                    member.settBirth(tBirth);
                                    member.settPhone(tPhone);

                                    sql.memberModify(member);
                                    break;

                                case 5:
                                    System.out.println("정말 삭제하시겠습니까? (y/n)");
                                    String checkDelete = sc.next();

                                    switch (checkDelete) {
                                        case "y":
                                            sql.memberDelete(tId);
                                            run1 = false;
                                            break;
                                        case "n":
                                            System.out.println("삭제를 취소합니다.");
                                            break;
                                        default:
                                            System.out.println("y와 n중에 입력해주세요.");
                                            break;
                                    }
                                    break;

                                case 6:
                                    System.out.println("로그아웃 합니다.");
                                    run1 = false;
                                    break;

                                default:
                                    System.out.println("다시 입력해주세요");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("로그인 실패");
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    sql.conClose();
                    break;

                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }
}