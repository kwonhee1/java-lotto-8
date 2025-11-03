# java-lotto-precourse

# 기능 
- 로또 결제 금액을 입력 받는다
- 개수 만큼 로또를 발행한다
- 당첨 번호와 보너스 번호를 입력 받는다
- 로또 추첨 결과를 구한다
- 결과를 출력한다

# 이번 주차 목표
- service 또한 한가지 일만 하게 분리한다 (Service UseCase분리)
- test 코드를 목적을 명확하게 하고 작성한다
- 한 가지의 기능을 두 가지의 class에서 실행하지 않는다

# class 정리
## domain
- Lotto :: lotto number의 일급컬렉션
  - 중복되지 않는 6개의 숫자를 가진다 (validate)
  - 각 숫자의 범위는 1~45이다 (validate)
- WinningLotto :: 당첨 로또 domain
  - 각 숫자의 범위는 1~45이다 (validate)
  - 중복되지 않는 6개의 숫자와 bonus 번호를 가진다 (domain)
  - Lotto와 비교하여 같은 숫자의 개수를 반환한다 (domain)
- LottoResult :: 로또의 결과를 나타내는 domain
  - 같은 숫자의 개수 만큼 등수를 나눈다 (domain 로직)
    - 6개 일치 = 1등
    - 5개 일치 + bonus일치 = 2등
    - 5개 일치 = 3등
    - 4개 일치 = 4등
    - 3개 일치 = 5등
  - 등수를 저장한다
## service use case
- GenerateLottoService :: 로또 생성 담당 (domain service)
- LotteryDrawService :: 로또 추첨 담당 (domain service)
- LottoAggregateService :: 결과 통합 담당 (application service)
## vo 
- LottoPurchasePrice :: 로또 구매 가격
- LottoPurchaseCount :: 로또 구매 횟수
## view
- InputView :: input
- OutputView :: output
- Mapper :: dto to String 담당
## controller
- LottoController :: 절차적 실행 담당