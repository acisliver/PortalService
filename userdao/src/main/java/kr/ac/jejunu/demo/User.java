package kr.ac.jejunu.demo;

import lombok.*;

@Data //value 기반 상호 참조되는 data가 되면 무한 회귀문제 발생
@Builder
@NoArgsConstructor  //기본생성자 만들어줌, Builder가 쓰는 AllArgsConstructor는 오버라이드(?)됨
@AllArgsConstructor //다시 파라미터들을 넣은 생성자 생성
public class User {
    private Integer id;
    private String name;
    private String password;
}
