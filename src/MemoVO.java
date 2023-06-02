import java.time.LocalDateTime;

public class MemoVO {
    private int memoNum;// 글 번호
    private String writerName;// 작성자 이름
    private String pass;// 비밀번호
    private String content;
    private LocalDateTime lastUpdatedDateTime;// 작성일(컴퓨터 시스템의 날짜와 시간을 자동으로 저장)

    // 생성자
    public MemoVO(String writerName, String pass, String content) {
        this.writerName = writerName;
        this.pass = pass;
        this.content = content;
    }
    static MemoVO newInstance(String writerName, String pass, String content){
        return new MemoVO(writerName, pass, content);
    }
    // 수정 날짜 시간 갱신
    void update(String content) {
        this.content = content;
        this.lastUpdatedDateTime = LocalDateTime.now();
    }
    public int getMemoNum() {
        return memoNum;
    }
    public String getWriterName() {
        return writerName;
    }
    public String getPass() {
        return pass;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

}
