# Universal web parsing

- jsoup, json-simple, quartz 라이브러리를 사용했다.

## 기능

- jsoup으로 웹을 파싱한다.
- quartz를 통해 주기적으로 파싱한다.
- json으로 파싱에 필요한 정보를 저장하고 불러온다.
- 웹에 변화를 감지하여 사용자에게 알려줌 notice() 메소드 커스텀.
- 변화감지에는 innerHTML 문자열의 length.

## config.json

```json config.json
{
  "url": "http://localhost:3000/",
  "sel": "body > ul",
  "interval": "*/3 * * * * ?",
  "length": 34
}
```

- url ; 파싱하고자하는 웹주소
- sel ; 감시하고싶은 html 오브젝트 셀렉터
- interval ; 파싱주기. 크론탭 포맷
- length ; innerHTML의 문자열 크기

## 개선사항

- config.json 갱신 기능
- 여러 웹 동시 파싱
- 그래들이나 메이븐 사용해서 라이브러리 관리하기
- 변화감지에 옵션(문자열 길이, 문자열 비교 ...)
- javadoc작성해 보기
