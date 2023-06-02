import java.util.Scanner;

public class Memo {

    private final MemoList memoList;

    public Memo() {
        this.memoList = new MemoList();
    }

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("안녕하세요. 메모장입니다");
            System.out.println("1.입력 2.목록 보기 3.수정 4.삭제 5.종료");
            System.out.println("번호를 입력해주세요");

            int selectedNumber = scanner.nextInt();

            if (1 == selectedNumber) {
                // 1. 입력
                memoList.addNote();
            } else if (2 == selectedNumber) {
                // 2. 목록 보기
                memoList.printAllNotes();
                //memoList.printNote();
            } else if (3 == selectedNumber) {
                // 3. 수정
                memoList.updateNote();
            } else if (4 == selectedNumber) {
                // 4. 삭제

                // 5. 종료
            } else if (5 == selectedNumber) {

            } else if (6 == selectedNumber) {
                break;
            } else {
                System.out.println("");
                System.out.println("번호를 다시입력해주세요");
                System.out.println("");
            }
        }
    }
}
