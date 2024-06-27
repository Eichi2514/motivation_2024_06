package org.koreait;

import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int number = 1;
        System.out.println("== motivation 실행 ==");

        while (true) {
            System.out.printf("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어를 입력해주세요");
                continue;
            }

            if (cmd.equals("add")) {
                System.out.printf("motivation : ");
                String motivation = sc.nextLine();
                System.out.printf("source : ");
                String source = sc.nextLine();

                System.out.println("== " + number + "번 motivation이 등록 되었습니다 ==");
                number++;
            }
        }
    }
}

// == 목표 ==
//명령어) 등록
//motivation :
//source :
//1번 motivation이 등록 되었습니다
//명령어) add
//motivation :
//source :
//2번 motivation이 등록 되었습니다
//
//명령어) 목록
//== motivation 목록 ==
//====================
//번호 / source / motivation
//  2  /        /
//  1  /        /
//
//명령어) 수정 2
//motivation :
//source :
//2번 motivation이 수정 되었습니다
//
//명령어) 삭제
//1번 motivation이 삭제 되었습니다
//
//명령어) system exit
//== motivation 종료 ==