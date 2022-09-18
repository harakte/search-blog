# search-blog

## 사용 라이브러리
- Spring Boot
- H2
- Lombok
- Feign
- MapStruct
- JPA

## API 명세
블로그 검색 서비스의 API 명세입니다.

## GET /search/blog 블로그 검색

### 기본 정보
- 키워드를 통해서 블로그를 검색할 수 있습니다.
- 검색 결과에서 정확도순과 최신순으로 정렬할 수 있습니다.
- 검색 결과는 페이징 형태로 제공합니다.
### Request
Query Parameter

| Name    | Type    | Description | Required |
|:--------|:--------|-------------|----------|
| keyword | String  | 검색 키워드      | O        |
| sort    | String  | 정렬 조건       | X        |
| page    | Integer | 페이지 번호      | X        |
| size    | Integer | 페이지 사이즈     | X        |

### Response
| Name               | Type       | Description |
|:-------------------|:-----------|-------------|
| totalCount         | Integer    | 총 검색 항목 수   |
| pageableCount      | Integer    | 페이징 된 항목 수  |
| isEnd              | Integer    | 페이징 끝 여부    |
| blogs              | Json Array | 블로그 정보      |
| blogs.title        | String     | 블로그 제목      |
| blogs.contents     | String     | 블로그 내용      |
| blogs.url          | String     | 블로그 url     |
| blogs.bloggerName  | String     | 블로거 이름      |
| blogs.postDateTime | DateTime   | 블로그 작성시간    |

## GET /popular/keywords 인기 검색어
### 기본 정보
사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 제공
검색어 별로 검색 횟수도 함께 제공
### Request
Query Parameter

| Name | Type    | Description | Required |
|:-----|:--------|-------------|----------|
| size | Integer | 키워드 개수      | X        |

### Response
| Name             | Type       | Description |
|:-----------------|:-----------|-------------|
| totalCount       | Integer    | 총 키워드 개수    |
| keywords         | Json Array | 키워드 정보      |
| keywords.keyword | String     | 키워드         |
| keywords.count   | Integer    | 키워드 검색 횟수   |
