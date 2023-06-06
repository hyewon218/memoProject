import java.util.Scanner;

public class MemoList {
    // for문으로 메모장의 개수만큼 반복해야 하므로 noteLength라는 변수를 만들어 0으로 초기화한다
    private int noteLength = 0;
    private final MemoVO[] memoVO;
    //노트 크기 지정
    private final int NOTE_SIZE = 100;

    public MemoList() {
        this.memoVO = new MemoVO[NOTE_SIZE];
    }

    // 1. 입력 기능
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

        // memoVO.[0] = MemoVO.newInstance(1, 최혜원, 123, 메모장입니다.);
        memoVO[this.noteLength++] = MemoVO.newInstance(noteLength, writerName, pass, content);

        // 방 하나하나 확인하기 위해 for문 반복문 필요!!!
        for (int i = 1; i < this.noteLength; i++) {
            MemoVO memo01 = memoVO[i];
            if (memo01 == null) {
                continue;
            }
            // 메모 삭제 후 입력할 시 메모 번호가 중복됨
            // 메모 번호가 중복된다면 메모 번호 1 크게 해서 인스턴스 초기화
            int num = memo01.getMemoNum();
            if (memoVO[i - 1].getMemoNum() == memoVO[i].getMemoNum()) {
                num++;
                memoVO[i] = MemoVO.newInstance(num, writerName, pass, content);
            }
        }

        System.out.println("메모가 작성되었습니다");
        System.out.println("");
    }

    // 2. 수정 기능
    public void updateNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("수정하실 메모의 번호를 입력해주세요.");
        int selectedNumber = Integer.parseInt(scanner.nextLine());
        int num = selectedNumber - 1;

        // 수정할 글이 존재하면 글을 수정하고 존재하지 않으면 존재하지 않는다고 메시지를 출력.
        System.out.println();
        MemoVO memo01 = memoVO[num];
        // 해당 번호의 메모가 비어있다면,
        if (null == memo01) {
            System.out.println("해당 번호의 메모가 존재하지 않습니다.");
            return;
        }

        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요.");
        String pass = scanner.nextLine();
        // 비밀번호가 일치 시 : 수정 내용 업데이트
        // 비밀번호 불일치 시 : 비밀번호가 일치하지 않는다는 메시지 출력

        if (!memo01.getPass().equals(pass)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }

        memo01.update(content);

        System.out.println("메모가 수정되었습니다");
        System.out.println("");
    }

    // 3. 삭제 기능
    // 새 메모를 추가하면 노트 배열의 마지막에 들어가는 방식이기에 특정 메모를 삭제하면
    // 그 메모만 삭제되는 것이 아니라 그 다음 번호부터 숫자를 1씩 낮춰 보여지도록
    public void deleteNote() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제하실 메모의 번호를 입력해주세요.");
        int selectedNumber = Integer.parseInt(scanner.nextLine());
        int num = selectedNumber - 1;

        // 수정할 글이 존재하면 글을 삭제하고 존재하지 않으면 존재하지 않는다고 메시지를 출력.
        MemoVO memo01 = memoVO[num];
        // 해당 번호의 메모가 비어있다면,
        if (null == memo01) {
            System.out.println("해당 번호의 메모가 존재하지 않습니다.");
            return;
        }

        System.out.println("비밀번호를 입력해주세요.");
        String pass = scanner.nextLine();

        if (!memo01.getPass().equals(pass)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }
        for (int i = selectedNumber; i <= this.noteLength; i++) {
            memoVO[i - 1] = memoVO[i];

            if (i == this.noteLength) {
                memoVO[i] = null;
            }
        }
        this.noteLength -= 1;

        System.out.println("메모가 삭제되었습니다");
        System.out.println("");
    }

    //////////////////////////////////////////////////////////////////
    // 4. 메모 전체 조회
    // 메모 전체를 조회할 수 있다.(Getter/Setter 존재)
    // 작성 최신 순으로 메모를 출력.
    public void printAllNotes() {
        System.out.println("");
        //System.out.println(noteLength);
        if (this.noteLength == 0) {
            System.out.println("작성된 메모가 없습니다");
            return;
        }
        for (int i = 0; i < this.noteLength; i++) {
            MemoVO memo01 = memoVO[i];
            if (memo01 == null) {
                continue;
            }
            int num = memo01.getMemoNum();

            String memo = String.format("방번호:%d 메모번호:%d 작성자이름:%s 작성내용:%s", i, num, memo01.getWriterName(),
                    memo01.getContent());
            System.out.println(memo);
        }
        System.out.println("");
    }
}

