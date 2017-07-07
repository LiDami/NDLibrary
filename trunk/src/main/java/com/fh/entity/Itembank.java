package com.my.db;

public class Itembank {
  private String it_id;
  private String topic;
  private String option_a;
  private String option_b;
  private String option_c;
  private String option_d;
  private Long flag;
  private Long rank;
  private String answer;

  public String getIt_id() {
    return it_id;
  }

  public void setIt_id(String it_id) {
    this.it_id = it_id;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getOption_a() {
    return option_a;
  }

  public void setOption_a(String option_a) {
    this.option_a = option_a;
  }

  public String getOption_b() {
    return option_b;
  }

  public void setOption_b(String option_b) {
    this.option_b = option_b;
  }

  public String getOption_c() {
    return option_c;
  }

  public void setOption_c(String option_c) {
    this.option_c = option_c;
  }

  public String getOption_d() {
    return option_d;
  }

  public void setOption_d(String option_d) {
    this.option_d = option_d;
  }

  public Long getFlag() {
    return flag;
  }

  public void setFlag(Long flag) {
    this.flag = flag;
  }

  public Long getRank() {
    return rank;
  }

  public void setRank(Long rank) {
    this.rank = rank;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
