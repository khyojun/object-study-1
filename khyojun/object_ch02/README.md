g
## CH 2. 객체 지향 프로그래밍

---

### 객체를 설계할 때

객체를 설계한다고 할 때 주로 클래스를 어떻게 구성할 지 메서드를 어떻게 구성할 지 고민을 많이 한다. 그치만 고민할 것은 그것이 아니라 아래의 2 가지이다.

1. 객체를 설계 할 때  **어떤 객체를
사용해야 할 지 고민해야 한다!**
2. 객체는 독립적인 존재가 아닌 서로 협력할 수 있게 설계하는 것이 좋다.(유연하고 확장 가능한 설계를 할 수 있다.)
---

### 🔍 도메인
>문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야를 **도메인이라고 한다!**

---

### 객체 지향은 강력하다!

여러가지 이유가 있겠지만 어떠한 요구사항이 주어질 때 추상화 기법을 사용하여 **설계의 처음부터 구현의 마지막 단계까지 사용이 가능하기 때문이다.** 

---
### 자율적인 객체가 되기 위하여

2 가지 사실을 알고 가야 한다.
>1. 객체는 상태(state), 행동(behavior)을 함께 가지는 **복합적인 존재**이다.
>2. 객체가 스스로 판단하고 행동하는 **자율적인 존재**이다.

### 캡슐화
> 캡슐화란 데이터, 기능을 객체 내부로 묶는 것이다.

객체 지향 이전에는 데이터, 기능을 독립적으로 엮어서 프로그램을 구성했다고 한다.
프로그래밍 언어에서는 캡슐화보다 더 나아가 외부에서 접근을 제한하는 접근 제어 메커니즘을 제공하는데 이는 우리가 알고있는 접근 수정자와 같은 것들이다.
`(protected, private, public)`



### 접근을 제한하는 이유
접근을 통제하면 객체를 자율적인 존재로 만들 수 있기 때문이다.???

외부에서의 간섭을 제한하면 -> 객체가 자유로워진다? -> 외부와 떨어지게 되면 구현하는데 자유로워지기 때문이다.

**구현하는데 자유로워진다는 말은 즉, 어떻게 수정을 하여도 본인에게만 영향이 가기 때문이다.**

외부에서 접근이 가능하면? -> 퍼블릭 인터페이스 영역이라고 부른다. : public 영역 
내부에서만 접근이 가능하면? -> 구현(implementation) 영역이라고 부른다. : private, protected 영역

이렇게 분류한 것을 **인터페이스와 구현의 분리원칙**이라고 한다.

#### 일반적으로는 객체의 상태(클래스의 속성)은 숨기고 행동(외부 제공 메소드)를 공개해야 한다.

---
### 프로그래머의 자유
프로그래머의 역할을 **클래스 작성자**, **클라이언트 프로그래머** 로 나누어 보자!

- 클래스 작성자 : 새로운 데이터 타입을 프로그램에 추가하는 역할
- 클라이언트 프로그래머 : 추가한 데이터 타입을 사용하는 역할

이때 만약에 앞에서 처럼 클래스의 속성에 대하여서 전부 public으로 해버리고 진행을 하면 클라이언트 프로그래머가 언제든지 접근이 가능해서 내부 구현을 변경할 수 있어진다.

그러나 접근 수정자등의 요소들을 사용하여서 내부 구현에 관한 내용을 숨겨서 접근을 못하게 해버리는 것을 **구현 은닉(implementation hiding)**이라고 한다.

**구현 은닉으로 얻게 되는 이점**
- 클라이언트 프로그래머가 인터페이스만 알고 있어도 클래스를 사용할 수 있기에 알아야 할 지식의 양이 적다.
- 클래스 작성자는 자유롭게 구현을 변경할 수 있는 폭이 넓어진다.

---

### 잠시 알아가면 좋은 점!

책의 예제에서도 나오지만 기본적으로 우리가 금액이라는 것을 선언할 때 long타입으로 선언하여 사용한다.

그치만 이렇게 하면 의미를 전달하긴 힘들다고 한다. 그래서 이런 경우에도 따로 Money라는 객체를 만들어 개념을 명시적으로 표현하게 되면 전체적인 설계의 명확성과 유연성을 높여갈 수 있다.

---

### 협력

> 객체들 사이에 이뤄지는 상호작용을 **협력(Collaboration)**이라고 한다.

객체들 사이에서 상호작용은 어떻게 하냐? 라고 하면 **메시지를 전송**하는 방법밖에 없다고 한다.

수신받은 객체가 메시지를 처리하기 위한 자신만의 방법을 **메서드**라고 부른다.

근데 우리가 이때까지 단순히 메서드 호출이라는 용어로만 객체끼리 서로 함수를 부르는 식으로 봤었다.
실은 **메서드 호출이라는 말도 맞지만 이건 메시지를 전송한다**라는 말이 더 적절한 표현이었다. 

### 🔍메시지 전송, 메서드 호출
여기서 너무 궁금했다. 메시지 전송의 뜻이 무엇일까? 
쉽게 이해하기 위해서 예시를 하나 들어보면 A라는 객체에서 B의 C라는 메서드를 부르기 위해서는
```java
public class A{
    
    private B b;
    b = new B();
    b.c();
    
}
```
이런식으로 부르겠지만 b.c라는 것을 처리는 B라는 객체로 이동해서 하지 실제로 A에서는 하지 않기에 이것은 그냥 `메시지를 전송`한다고 한다.

그러면 B에 가서는 c를 처리하기 때문에 이때 c라는 행위를 메서드라고 한다.  


### 컴파일 시간 의존성과 실행 시간 의존성

> 어떤 클래스가 다른 클래스에 접근 할 수 있는 경로를 가지거나 해당 클래스의 객체의 메서드를 호출할 경우 **두 클래스 사이의 의존성이 존재한다고 한다.**

이 의존성이라는 것을 컴파일 시간, 실행 시간에 따른 의존성으로 분류가 된다

할인 정책을 예시로 볼 때
- DiscountPolicy : 추상화된 할인 정책
- AmountDiscountPolicy : 구체화된 할인 정책 1
- PercentDiscountPolicy : 구체화된 할인 정책 2

앞의 객체에 해당하는 부분에 애초에 DiscountPolicy라는 추상 클래스만 있을 경우
```java
~~~ new(AmountDiscountPolicy())
```
- 컴파일 시간에서의 의존성 : DiscountPolicy를 보게 된다.
- 실행 시간에서의 의존성 : AmountDiscountPolicy 인스턴스를 보게 된다.
 
이러면 컴파일 시간에서의 의존성(코드의 의존성), 실행 시간에서의 의존성은 다를 수 있다. 그런데 이러면 코드가 이해하기 어려워진다.

그래서 이런 부분들은 잘 조율을 해야하는 것이 코드가 이해가 잘 되는 부분을 선택할 것인지, 코드가 더 유연해지고 확장 가능하게 설계할 지 잘 저울질을 해야겠다.

---
### 상속
> **상속** : 기존의 클래스와 너무 흡사하여 조금의 코드만 가져와 추가하거나 수정하고 싶을 때 기존 클래스의 코드를 전혀 수정하지 않고 재사용할 수 있게 만드는 것

그런데 이점을 보면 기존의 것에다가 다른 부분만을 추가하여 새로운 클래스를 쉽고 빠르게 만들기에 이를 **차이에 의한 프로그래밍**이라고 한다.

### 인터페이스
> **인터페이스** : 객체가 이해할 수 있는 메시지의 목록을 정의

---

### 업캐스팅
어찌 보면 다형성과 완전 연결되어있는 업캐스팅이다.
> **업캐스팅**: 자식 클래스가 부모 클래스를 대신하는 것

이게 왜 다형성이랑 크게 연결이 되냐면 결국 부모 클래스의 자리에 대신해서 성질은 같지만 다른 형태의 자식 클래스들이 누구나 올 수 있기 때문이다.

### 다형성
>**다형성**: 동일한 메시지를 수신했을 때 객체의 타입에 따라 다르게 응답할 수 있는 능력

이제 알아야 할 것이 다형성은 컴파일 시점이 아니라 실행 시점에 따라 실행될 메서드가 결정이 된다.
그래서 이때 메시지와 메서드를 실행 시점에 바인딩을 한다는 것인데 이를 **`지연 바인딩`**, `동적 바인딩`이라고 한다.

그리고 그 반대로 컴파일 시점에 바인딩 하는 것을 **`초기 바인딩`**, **`정적 바인딩`**이라고 한다. 

>객체 지향에서는 컴파일 시점에서의 의존성과 실행 시점의 의존성을 분리하고, 하나의 메시지를 선택적으로 서로 다른 메서드에 연결 할 수 있는 이유가 바로
`지연 바인딩`이라는 메커니즘을 사용하기 때문이다.


---

### 추상화의 힘!

- 요구사항의 정책을 높은 수준에서 서술할 수 있다는 것
- 설계가 조금 더 유연해진다는 것
그래서 유연성이 필요한 곳에서는 꼭 추상화를 사용해야 하는 것이 중요하다!

---
### 추상 클래스와 인터페이스의 트레이드오프

예를 들어 할인 정책을 실시한다고 했을때 정책이 2가지가 있고 예외적으로 한 가지는 할인이 되지 않을 때인데 책의 예제를 보면 기본적으로 할인 정책이 적용되지 않았을때에 대한 처리를 예외 처리하듯이 해놨었다.

그런데 이것을 그렇게 처리하지 말고 기존에 있던 `DiscountPolicy` 추상 클래스를 인터페이스로 변경시키고 기존의 기능들을 `DefaultDiscountPolicy`로 옮겨서 받아 생성하기로 했다.

```java
public interface DiscountPolicy{
    Money calculateDiscountAmount(Screening screening);    
}
```

```java
public abstract class DefaultDiscountPolicy implements DiscountPolicy{
    ...
}

```


```java

public class NoneDiscountPolicy implements DiscountPolicy{
    @Override
    public Money calculateDiscountAmount(Screening screening){
        return Money.ZERO;
    }
}
```

이런식으로 설계를 하면 개념적으로 명확해진다는 점이 있긴 하지만 이 할인금액 0원 때문에 이와 같은 작업을 하는 것이 과하다고 느낄 수도 있지만 의미가 명확해진다는 장점이 있다.
그래서 이런 부분에서 잘 고민하고 트레이드오프를 해야 한다.

---


### 합성 

> 합성이란 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 재사용하는 방법을 일컫는다.

그런데 합성이라는 것은 코드 재사용성 측면에서 보면 상속보다는 훨씬 좋다고 한다. 왜?

#### 상속의 단점

상속에서의 단점이 있다.
1. 캡슐화를 위반한다.
2. 설계를 유연하게 만들지 못한다.

그래서 보면 이전의 `AmountDiscountPolicy` 를 `DiscountPolicy` 에서 상속받는 것이 아닌 `Movie`라는 객체에서 상속받아 한 단계 덜 상속을 받는 것이다. 
이렇게 계속해서 합성해서 줄여나가면 상속이 지닌 위 2가지 문제점을 해결하긴 하지만.... 그렇다고 이것만 사용하면 그건 좀 아니다.

왜냐하면 다형성때문에 인터페이스를 재사용하는 경우에는 상속을 또 사용해야하기 때문이다. 그래서 적절하게 또 저울질 하며 잘 섞어서 사용해야겠다.


