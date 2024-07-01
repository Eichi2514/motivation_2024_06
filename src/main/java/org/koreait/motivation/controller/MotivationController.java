package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    int deleteCount = 1;
    int lastId;

    HashMap<Integer, String> motivations;

    public MotivationController() {
        lastId = 0;
        motivations = new HashMap<>();
    }

    public void add() {
        int id = lastId + 1;
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        motivations.put(id * 10, body);
        motivations.put(id * 11, source);


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

            for (int i = ((motivations.size() / 2) - 1); i >= 0; i--) {
                int id = i + 1;
                if (motivations.get(id * 11).length() > 3) {
                    System.out.println("   " + (id) + "   //   " + motivations.get(id * 11).substring(0, 3) + "...   // " + motivations.get(id * 10));
                } else {
                    System.out.println("   " + (id) + "   //   " + motivations.get(id * 11) + "   // " + motivations.get(id * 10));
                }
            }
        }
    }

    public void change(String cmd) {
        if (cmd.length() <= 6) {
            System.out.println("change 뒤에 수정할 번호를 추가해주세요");
        } else {
            try {
                int id = Integer.parseInt(cmd.substring(6));
                if (motivations.size() == 0) {
                    System.out.printf("%d번 motivation은 존재하지 않습니다\n", id);
                } else if (cmd.length() > 6) {
                    System.out.print("body : ");
                    String body = Container.getScanner().nextLine();
                    System.out.print("source : ");
                    String source = Container.getScanner().nextLine();

                    Motivation motivation = new Motivation(id, body, source);

                    motivations.remove(id * 10);
                    motivations.remove(id * 11);
                    motivations.put(id * 10, body);
                    motivations.put(id * 11, source);

                    System.out.printf("%d번 motivation이 수정되었습니다\n", id);
                } else {
                    System.out.println("없는 command 입니다");
                }
            } catch (NumberFormatException e) {
                System.out.println(cmd.substring(6) + "란 번호는 사용할 수 없습니다");
                return;
            }
        }
    }

    public void delete(String cmd) {
        if (cmd.length() == 6) {
            System.out.println("delete 뒤에 삭제할 번호를 추가해주세요");
        } else {
            try {
                int id = Integer.parseInt(cmd.substring(6));

                if (cmd.length() > 6) {
                    if (id < 0 || (id + 1) > motivations.size()) {
                        System.out.printf("%d번 motivation은 존재하지 않습니다\n", id);
                    } else {
                        motivations.remove(id * 10);
                        motivations.remove(id * 11);

                        System.out.printf("%d번 motivation이 삭제되었습니다\n", id);
                    }
                } else {
                    System.out.println("없는 command 입니다");
                }
            } catch (NumberFormatException e) {
                System.out.println(cmd.substring(6) + "란 번호는 사용할 수 없습니다");
                return;
            }
        }
    }

    public void source(String cmd) {
        if (cmd.length() <= 6) {
            System.out.println("source 뒤에 삭제할 번호를 추가해주세요");
        } else {
            try {
                int id = Integer.parseInt(cmd.substring(6));

                if (cmd.length() > 6) {
                    if (id < 0 || (id + 1) > motivations.size()) {
                        System.out.printf("%d번 source는 존재하지 않습니다\n", id);
                    } else {

                        System.out.printf("%d번 source : %s\n", id, motivations.get(id * 11));
                    }
                } else {
                    System.out.println("없는 command 입니다");
                }
            } catch (NumberFormatException e) {
                System.out.println(cmd.substring(6) + "란 번호는 사용할 수 없습니다");
                return;
            }
        }
    }
}

//public class MotivationController {
//
//    int deleteCount = 1;
//    int lastId;
//    List<Motivation> motivations;
//
//    public MotivationController() {
//        lastId = 0;
//        motivations = new ArrayList<>();
//    }
//
//    public void add() {
//        int id = lastId + 1;
//        System.out.print("body : ");
//        String body = Container.getScanner().nextLine();
//        System.out.print("source : ");
//        String source = Container.getScanner().nextLine();
//
//        Motivation motivation = new Motivation(id, body, source);
//
//        motivations.add(motivation);
//
//        System.out.printf("%d번 motivation이 등록 되었습니다\n", id);
//        lastId++;
//    }
//
//    public void list() {
//        if (motivations.size() == 0) {
//            System.out.println("등록된 motivation이 없습니다");
//        } else {
//            System.out.println("============ motivation list ============");
//            System.out.printf("  id   //   source   // motivation \n");
//            System.out.println("=".repeat(41));
//
//            for (int i = motivations.size() - 1; i >= 0; i--) {
//                Motivation motivation = motivations.get(i);
//                if (motivation.getSource().length() > 3) {
//                    System.out.printf("   %d   //   %s   // %s \n", motivation.getId(), motivation.getSource().substring(0, 3) + "...", motivation.getBody());
//                } else {
//                    System.out.printf("   %d   //   %s   // %s \n", motivation.getId(), motivation.getSource(), motivation.getBody());
//                }
//            }
//        }
//    }
//
//    public void change(String cmd) {
//        int id = Integer.parseInt(String.valueOf(cmd.charAt(cmd.length() - 1)));
//        if (motivations.size() == 0) {
//            System.out.printf("%d번 motivation은 존재하지 않습니다\n", id);
//        }
//        if (cmd.length() == 6) {
//            System.out.println("change 뒤에 수정할 번호를 추가해주세요");
//        } else {
//            System.out.print("body : ");
//            String body = Container.getScanner().nextLine();
//            System.out.print("source : ");
//            String source = Container.getScanner().nextLine();
//
//            Motivation motivation = new Motivation(id, body, source);
//
//            motivations.set(id - 1, motivation);
//
//            System.out.printf("%d번 motivation이 수정되었습니다\n", id);
//        }
//    }
//
//    public void delete(String cmd) {
//        int id = Integer.parseInt(String.valueOf(cmd.charAt(cmd.length() - 1)));
//        if (cmd.length() == 6) {
//            System.out.println("delete 뒤에 삭제할 번호를 추가해주세요");
//        } else if ((id - deleteCount) < 0 || (id - deleteCount + 1) > motivations.size()) {
//            System.out.printf("%d번 motivation은 존재하지 않습니다\n", id);
//        } else {
//            motivations.remove(id - deleteCount);
//
//            System.out.printf("%d번 motivation이 삭제되었습니다\n", id);
//            if (motivations.size() == id){deleteCount++;}
//        }
//    }
//}
