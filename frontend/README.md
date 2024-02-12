주소

- 포트 : 10001
- Swagger 기본 주소 http://localhost:10001/swagger-ui/index.html

Repository 생성 규칙

- Repository는 엔티티명 + Manage or 엔티티명 + Support등으로 엔티티와 1:1이 되도록 생성할 것

- manager : 등록, 변경, 삭제
- support : 조회
- 기본 Repository : Service에서 repository 영역으로 엔티티를 보내야 하는 경우 ID 조회용

규칙

- java 파일 생성시 추상 클래스라면 접두어로 Abstract, 인터페이스는 앞에 Base 붙여주세요.
- 파라미터 변수명 지을때 한단어단 8글자가 넘어가면 약어로 8글자 이내면 전체단어로 작성해주세요.
- 예/아니오 형태의 칼럼에 대해서는 Character형태로 사용한다.
- 칼럼의 length는 기본적으로 30으로 사용한다. 긴 이름은 100자, 그 이상은 알아서
- Character형태는 length = 1, ID는 Long 19자로 표현
- 날짜를 받는 경우 YYYY-MM-DD HH:MM:SS 형태로 받는다.
- 시간이 없는 경우는 YYYY-MM-DD만

ProtoTypeData.java 파일
관리는 필요하지만 프로토타입 기준으로 엔티티 정의를 하지 않을 데이터들

mvn: command not found 오류는 Maven 실행 파일이 시스템 경로에 없음을 나타냅니다. 이것은 Maven이 시스템에 설치되지 않았거나 시스템 경로에 추가되지 않았을 때 발생합니다.

해결하기 위해 다음 단계를 따르세요:

Maven 설치: 먼저 Maven을 설치해야 합니다. Apache Maven 웹 사이트(https://maven.apache.org/download.cgi)에서 Maven을 다운로드하고 설치하세요. 설치가 완료되면 mvn 명령을 실행할 수 있어야 합니다.

환경 변수 설정: Maven이 설치된 디렉토리의 bin 폴더를 시스템 경로에 추가해야 합니다. 이를 위해 환경 변수를 설정해야 합니다.

Linux/macOS: .bashrc, .bash_profile, 또는 .zshrc와 같은 셸 프로필 파일에 다음을 추가하세요:

bash
Copy code
export PATH=/path/to/apache-maven/bin:$PATH
여기서 /path/to/apache-maven은 Maven이 설치된 디렉토리를 나타냅니다.

Windows: 시스템 속성에서 환경 변수를 편집하고, 시스템 변수 중 Path를 선택한 후 Maven 설치 디렉토리의 bin 폴더 경로를 추가하세요.

터미널 재시작: 환경 변수 변경 후에는 터미널을 다시 시작하여 변경 사항을 적용하세요. 그런 다음 mvn --version 명령을 다시 실행하여 Maven 설치가 올바르게 이루어졌는지 확인하세요.

위 단계를 따라 Maven을 설치하고 환경 변수를 설정한 후에는 Maven 명령을 실행하여 정상적으로 작동하는지 확인하세요. 그러면 Maven을 사용하여 프로젝트를 빌드하고 실행할 수 있게 됩니다.
