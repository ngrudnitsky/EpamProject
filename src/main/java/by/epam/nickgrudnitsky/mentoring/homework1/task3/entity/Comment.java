package by.epam.nickgrudnitsky.mentoring.homework1.task3.entity;

import java.util.Objects;

@SuppressWarnings("unused") //Used to suppress 'unused' warnings
public class Comment extends BaseEntity{

    private static Integer idCounter = 0;
    private final Integer id = ++idCounter;

    private long userId;

    private long articleId;

    private String content;

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Comment comment = (Comment) o;

        if (userId != comment.userId) return false;
        if (articleId != comment.articleId) return false;
        if (!Objects.equals(id, comment.id)) return false;
        return Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (articleId ^ (articleId >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
