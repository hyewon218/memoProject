import java.util.Scanner;

public class MemoList {
    private int noteLength = 0;
    private final MemoVO[] memoVO;
    private final int NOTE_SIZE = 20;

    public MemoList() {
        this.memoVO = new MemoVO[NOTE_SIZE];
    }

    public void addNote() {
        System.out.println("");
        if (NOTE_SIZE == this.noteLength) {
            System.out.println("메모가 꽉찼습니다");
            System.out.println("");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력해주세요");
        String writerName = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요");
        String pass = scanner.nextLine();

        System.out.println("내용을 입력해주세요");
        String content = scanner.nextLine();

        memoVO[this.noteLength++] = MemoVO.newInstance(writerName, pass, content);

        System.out.println("메모가 작성되었습니다");
        System.out.println("");
    }

    public void updateNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("수정하실 메모의 번호를 입력해주세요");
        int selectedNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        MemoVO memoVO1 = memoVO[selectedNumber];
        if (null == memoVO1) {
            System.out.println("존재하지 않는 메모입니다");
            return;
        }
        memoVO1.update(content);

        System.out.println("메모가 수정되었습니다");
        System.out.println("");
    }

    public void printNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("확인할 메모의 번호를 입력해주세요");
        int selectedNumber = scanner.nextInt();
        MemoVO memoVO01 = memoVO[selectedNumber];
        if (null == memoVO01) {
            System.out.println("작성된 메모가 없습니다");
            System.out.println("");
            return;
        }
        System.out.println("");
        String headLine = String.format("번호:%d 작성자이름:%s", selectedNumber, memoVO01.getWriterName());
        System.out.println(headLine);
        System.out.println(memoVO01.getLastUpdatedDateTime());
        System.out.println(memoVO01.getContent());
        System.out.println("");
    }

    public void printAllNotes() {
        System.out.println("");
        if (0 == this.noteLength) {
            System.out.println("작성된 메모가 없습니다");
            System.out.println("");
            return;
        }
        for (int i = 0; i < this.noteLength; i++) {
            MemoVO memoVO01 = memoVO[i];

            String headLine = String.format("번호:%d 작성자이름:%s 작성날짜:%s", i, memoVO01.getWriterName(),
                    memoVO01.getLastUpdatedDateTime());
            System.out.println(headLine);
        }
        System.out.println("");
    }

}
