package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int lastid = 1;
        ArrayList<String> Memo = new ArrayList<>();
        System.out.println("== motivation execution ==");

        while (true) {
            System.out.printf("command) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== motivation exit ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("command를 입력해주세요");
                continue;
            }

            if (cmd.equals("add")) {
                System.out.printf("motivation : ");
                String motivation = sc.nextLine();
                System.out.printf("source : ");
                String source = sc.nextLine();

                Memo.add(Integer.toString(lastid));
                Memo.add(motivation);
                Memo.add(source);


                System.out.println("== " + lastid + "번 motivation이 등록 되었습니다 ==");
                lastid++;
            }
            if (cmd.equals("list")) {
                if (Memo.size() == 0) {
                    System.out.println("등록된 motivation이 없습니다");
                } else {
                    System.out.println("id // motivation // source");
                    for (int i = Memo.size() - 1; i > 0; i -= 3) {
                        System.out.println(Memo.get(i - 2) + " // " + Memo.get(i - 1) + " // " + Memo.get(i));
                    }
                }
            }

            if (cmd.contains("remove")) {
                if (cmd.length() > 6) {
                    int ListIndex = cmd.charAt(cmd.length() - 1);
                    ListIndex -= 49;
                    Memo.remove(ListIndex - 0);
                    Memo.remove(ListIndex + 1);
                    Memo.remove(ListIndex + 2);
                    System.out.println((ListIndex + 1) + "번이 삭제 되었습니다");
                } else {
                    System.out.println("error : remove뒤에 수정할 번호를 추가해주세요");
                }
            }
        }
    }
}

