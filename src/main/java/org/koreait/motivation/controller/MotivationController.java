package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    int deleteCount = 0;
    int lastId;
    List<Motivation> motivations;

    public MotivationController() {
        lastId = 0;
        motivations = new ArrayList<>();
    }

    public void add() {
        int id = lastId + 1;
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        Motivation motivation = new Motivation(id, body, source);

        motivations.add(motivation);

        System.out.printf("%d번 motivation이 등록 되었습니다\n", id);
        lastId++;
    }

    public void list() {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation이 없습니다");
        } else {
            System.out.println("============ motivation list ============");
            System.out.printf("  id   //   source   // motivation \n");
            System.out.println("=".repeat(41));

            for (int i = motivations.size() - 1; i >= 0; i--) {
                Motivation motivation = motivations.get(i);
                if (motivation.getSource().length() > 3) {
                    System.out.printf("   %d   //   %s   // %s \n", motivation.getId(), motivation.getSource().substring(0, 3) + "...", motivation.getBody());
                } else {
                    System.out.printf("   %d   //   %s   // %s \n", motivation.getId(), motivation.getSource(), motivation.getBody());
                }
            }
        }
    }

    public void change(String cmd) {

        if (cmd.length() == 6) {
            System.out.println("change 뒤에 수정할 번호를 추가해주세요");
        } else {
            int id = Integer.parseInt(String.valueOf(cmd.charAt(cmd.length() - 1)));
            System.out.print("body : ");
            String body = Container.getScanner().nextLine();
            System.out.print("source : ");
            String source = Container.getScanner().nextLine();

            Motivation motivation = new Motivation(id, body, source);

            motivations.set(id - 1, motivation);

            System.out.printf("%d번 motivation이 수정되었습니다\n", id);
        }
    }

    public void delete(String cmd) {
        if (cmd.length() == 6) {
            System.out.println("delete 뒤에 삭제할 번호를 추가해주세요");
        } else {
            int id = Integer.parseInt(String.valueOf(cmd.charAt(cmd.length() - 1)));

            motivations.remove(id - 1 - deleteCount);

            System.out.printf("%d번 motivation이 삭제되었습니다\n", id);
            deleteCount++;
        }
    }
}
