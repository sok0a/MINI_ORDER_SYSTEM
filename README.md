
# JASP: 미니 주문 시스템

JASP 미니 주문 시스템은 여러 엔티티 클래스를 사용하여 시스템 내의 다양한 객체를 나타냅니다. 모든 엔티티는 `Common` 추상 클래스에서 상속받아 고유 식별자를 가지며, Lombok 애노테이션을 사용하여 보일러플레이트 코드를 최소화합니다.

---

### Lombok 애노테이션

모든 엔티티 클래스에 공통적으로 사용되는 Lombok 애노테이션은 다음과 같습니다:

- **@Getter**: 모든 필드에 대한 게터 메서드를 자동으로 생성하여, 필드에 대한 읽기 접근을 제공합니다.

- **@ToString**: 객체의 모든 필드를 포함하는 `toString()` 메서드를 자동으로 생성하여, 객체의 문자열 표현을 쉽게 얻을 수 있게 합니다.

- **@EqualsAndHashCode(callSuper = true)**: 상위 클래스의 `equals()`와 `hashCode()`를 호출하여 상속받은 `id` 필드도 비교에 포함되도록 합니다. `callSuper = true` 옵션은 상위 클래스의 필드를 포함하여 `equals()`와 `hashCode()` 메서드를 생성합니다.

- **@AllArgsConstructor**: 모든 필드를 매개변수로 가지는 생성자를 자동으로 생성하여 객체 생성 시 필드 값을 간편하게 설정할 수 있게 합니다.

이러한 애노테이션은 아래 클래스 정의에 포함됩니다:

```java
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
```

---

### Common 클래스

`Common` 클래스는 고유 식별자를 제공하기 위해 설계된 추상 기본 클래스입니다.

#### 클래스 구조

```java
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Common {

    // 정적 변수로 고유 식별자를 위한 시퀀스 초기화
    private static int sequence = 0;

    // 고유 식별자 필드
    @EqualsAndHashCode.Include
    @Getter(value = AccessLevel.PUBLIC)
    private Integer id;

    // 생성자
    public Common() {
        // 고유 식별자 증가 및 할당
        this.id = ++sequence;
    }
}
```

---

## Item 클래스

`Item` 클래스는 상품을 나타내며, 상품의 이름, 가격, 카테고리를 관리합니다.

#### 필드

- `itemName`: 상품의 이름을 저장하는 문자열 필드입니다.
- `itemPrice`: 상품의 가격을 저장하는 정수형 필드입니다.
- `category`: 상품의 카테고리를 나타내는 `Category` 타입의 필드입니다.

#### Category 열거형

- `Category` 열거형은 상품의 유형을 분류하기 위해 사용되며, 다양한 카테고리를 정의합니다.

#### 클래스 구조

```java
public enum Category {
    // 전자 제품, 의류, 식료품, 가구, 도서, 장난감
    ELECTRONICS, CLOTHING, GROCERY, FURNITURE, BOOKS, TOYS
}
```
```java
public class Item extends Common {

    // 상품 이름
    // 상품 가격
    // 상품 카테고리
}
```

---

### Account 클래스

`Account` 클래스는 은행 계좌를 나타내며, 계좌 번호, 잔액, 그리고 입출금 기능을 제공합니다.

#### 필드

- `accountNumber`: 계좌 번호를 저장하는 문자열 필드입니다.
- `balance`: 계좌의 잔액을 저장하는 정수형 필드입니다.

#### 메서드

- `withdraw(int amount)`: 특정 금액을 출금하는 메서드입니다.
- `deposit(int amount)`: 특정 금액을 입금하는 메서드입니다.

#### 클래스 구조

```java
public class Account extends Common {

    // 계좌 번호
    // 계좌 잔액

    // 출금 메서드
    // 입금 메서드
    
}
```

---

### Member 클래스

`Member` 클래스는 회원 정보를 관리하며, 이메일, 비밀번호, 닉네임 및 계좌 정보를 저장합니다.

#### 필드

- `email`: 회원의 이메일을 저장하는 문자열 필드입니다.
- `password`: 회원의 비밀번호를 저장하는 문자열 필드입니다.
- `nickname`: 회원의 닉네임을 저장하는 문자열 필드입니다.
- `account`: 회원의 계좌 정보를 저장하는 `Account` 객체 필드입니다.

#### 클래스 구조

```java
public class Member extends Common {

    // 회원 이메일
    // 회원 비밀번호
    // 회원 닉네임
    // 회원 계좌
    
}
```

---

### Order 클래스

`Order` 클래스는 주문 정보를 관리하며, 주문한 회원, 상품 목록, 주문 코드, 주문 날짜, 총 상품 수량 및 총 상품 금액을 저장합니다.

#### 필드

- `member`: 주문을 한 회원을 나타내는 `Member` 객체 필드입니다.
- `orderedItemList`: 주문한 상품 목록을 저장하는 `List<Item>` 필드입니다.
- `orderCode`: 주문 코드를 저장하는 문자열 필드로, 고유한 `UUID`를 생성하여 초기화됩니다.
- `orderDate`: 주문 날짜를 저장하는 `LocalDateTime` 필드로, 주문 생성 시 현재 날짜와 시간으로 초기화됩니다.
- `totalItemCount`: 총 주문 상품 수량을 저장하는 정수형 필드입니다.
- `totalItemAmount`: 총 주문 상품 금액을 저장하는 정수형 필드입니다.

#### 메서드

- `addItem(List<Item> orderedItemList)`: 주문에 상품을 추가하는 메서드입니다.
- `removeItem(Item item)`: 주문에서 상품을 제거하는 메서드입니다.
- `updateOrder(Item item, int price, boolean isAdd)`: 주문 목록 및 총 금액과 수량을 업데이트하는 내부 메서드입니다.

#### 클래스 구조

```java
public class Order extends Common {

    // 주문 회원
    // 주문한 상품 목록
    // 주문 코드
    // 주문 날짜
    // 총 상품 수량
    // 총 상품 금액

    // 생성자
    public Order(Member member, List<Item> orderedItemList) {
        // 주문 생성 로직
    }

    // 상품 추가 메서드
    // 상품 제거 메서드
    
    // 주문 업데이트 메서드
    private boolean updateOrder(Item item, int price, boolean isAdd) {
        if (isAdd) {
            // 상품 추가 로직
            // 주문 목록에 item 추가
            // totalItemAmount에 price 추가
            // totalItemCount 증가
        } else {
            // 상품 제거 로직
            // 주문 목록에서 item 제거
            // totalItemAmount에서 price 감소
            // totalItemCount 감소
        }
        return true;
    }
    
}
```

---

# Repository

## 공통 기능

모든 저장소 클래스는 `Repository` 인터페이스를 구현하여 기본적인 CRUD(생성, 읽기, 갱신, 삭제) 기능을 제공합니다. 각 저장소는 스레드에 안전한 `ConcurrentHashMap`을 사용하여 데이터 저장소를 구현하며, `Repository` 인터페이스의 메서드를 구현합니다.

### 공통 메서드 설명

- **`save(T entity)`**: 지정된 엔티티를 저장소에 저장합니다. 엔티티의 고유 ID를 키로 사용하여 저장소에 저장합니다.

- **`T findById(int id)`**: 주어진 ID를 사용하여 저장소에서 엔티티를 검색하고 반환합니다. ID가 저장소에 존재하지 않으면 `null`을 반환합니다.

- **`List<T> findAll()`**: 저장소에 있는 모든 엔티티를 리스트 형태로 반환합니다.

- **`boolean update(T entity)`**: 주어진 엔티티가 저장소에 존재하는 경우 업데이트하고, 성공 여부를 반환합니다. 엔티티가 존재하지 않으면 `false`를 반환합니다.

- **`boolean delete(int id)`**: 주어진 ID의 엔티티를 저장소에서 삭제하고, 성공 여부를 반환합니다. 엔티티가 존재하지 않으면 `false`를 반환합니다.

- **`default boolean notExists(Map<Integer, T> db, int id)`**: 주어진 ID의 엔티티가 저장소에 존재하지 않음을 확인합니다.

```java
public interface Repository<T> {

    void save(T entity);
    
    T findById(int id);
    
    List<T> findAll();
    
    boolean update(T entity);
    
    boolean delete(int id);

    default boolean notExists(Map<Integer, T> db, int id) {
        return !db.containsKey(id);
    }
}
```

---

## 저장소 클래스 구현

각 엔티티 타입별 저장소 클래스는 다음과 같이 `Repository` 인터페이스를 구현하여 기본적인 CRUD 작업을 수행합니다. 각 저장소 클래스는 `ConcurrentHashMap`을 사용하여 엔티티 객체를 저장하고 관리합니다.

---
### AccountRepository 클래스

#### 클래스 구조

```java
public class AccountRepository implements Repository<Account> {

    private static final Map<Integer, Account> DB = new ConcurrentHashMap<>();

    // Account 엔티티에 대한 CRUD 메서드를 구현
    // save, findById, findAll, update, delete
}
```
---

### ItemRepository 클래스

#### 클래스 구조

```java
public class ItemRepository implements Repository<Item> {

    private static final Map<Integer, Item> DB = new ConcurrentHashMap<>();

    // Item 엔티티에 대한 CRUD 메서드를 구현
    // save, findById, findAll, update, delete
}
```
---
### MemberRepository 클래스

#### 클래스 구조

```java
public class MemberRepository implements Repository<Member> {

    private static final Map<Integer, Member> DB = new ConcurrentHashMap<>();

    // Member 엔티티에 대한 CRUD 메서드를 구현
    // save, findById, findAll, update, delete
}
```
---

### OrderRepository 클래스

#### 클래스 구조

```java
public class OrderRepository implements Repository<Order> {

    private static final Map<Integer, Order> DB = new ConcurrentHashMap<>();

    // Order 엔티티에 대한 CRUD 메서드를 구현
    // save, findById, findAll, update, delete
}
```

---



