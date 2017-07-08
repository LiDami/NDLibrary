package  com.fh.entity;


public class Scoreresult {
  private String sc_id;
  private String name;
  private String number;
  private Long score;
  private Long start_time;
  private Long end_time;
  private Long total_time;

  public String getSc_id() {
    return sc_id;
  }

  public void setSc_id(String sc_id) {
    this.sc_id = sc_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public Long getStart_time() {
    return start_time;
  }

  public void setStart_time(Long start_time) {
    this.start_time = start_time;
  }

  public Long getEnd_time() {
    return end_time;
  }

  public void setEnd_time(Long end_time) {
    this.end_time = end_time;
  }

  public Long getTotal_time() {
    return total_time;
  }

  public void setTotal_time(Long total_time) {
    this.total_time = total_time;
  }
}
