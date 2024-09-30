# PlayStoreGameView

PlayStoreGameView는 Android에서 Google Play 게임 탭과 유사한 UI를 구현하기 위한 프로젝트입니다.  
두 개의 모듈(app, playstore-gameview)로 나뉘어 구성되어 있으며 playstore-gameview 모듈에서 제공하는 커스텀 뷰를 활용하여 다양한 게임 리스트를 구현할 수 있습니다.

## 모듈 설명

**1. app 모듈**

- 메인 애플리케이션 모듈입니다.
- RecyclerView를 사용하여 게임 목록을 표시하고, playstore-gameview 모듈에서 구현된 커스텀 뷰를 활용하여 Google Play Games와 유사한 UI를 구성합니다.
- 예시로 게임 탭 화면을 구현하였습니다.

**2. playstore-gameview 모듈**

- 커스텀 뷰가 구현된 모듈입니다.
- 이 모듈은 게임 데이터를 표현하기 위한 다양한 뷰 옵션을 제공합니다..
- app 모듈에서는 이 모듈에서 구현된 커스텀 뷰를 불러와 동적인 UI를 구성할 수 있습니다.

## 커스텀 뷰 종류
이 프로젝트에서는 게임 항목을 표현하기 위한 네 가지 cardType 옵션을 제공합니다. 각 타입은 다양한 게임 리스트를 시각화할 수 있는 커스텀 뷰입니다.

**카드 타입은 네 가지가 있으며, 각 타입은 다양한 게임 리스트를 표현하는 데 사용됩니다:**
- big_promo_image: 큰 프로모션 이미지를 표시합니다.
- list: 리스트 형식으로 게임 항목을 표시합니다.
- small_image: 작은 이미지를 사용하여 간략한 게임 정보를 표시합니다.
- big_featured_image: 큰 이미지와 주요 정보를 강조한 형식으로 게임 항목을 표시합니다.

## 커스텀 뷰 사용 예시

**1. BigImagePromoItem과 같은 큰 이미지 아이템을 표시할 때:**
```
<com.quessr.playstore_gameview.GameListView
    android:id="@+id/bigImagePromoGameListView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:cardType="big_promo_image"
    app:categoryTitleVisibility="gone"
    app:imageViewSize="small"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```
- 옵션: cardType="big_promo_image"으로 설정하여 큰 프로모션 이미지를 표시합니다.
- imageViewSize 옵션을 사용하여 이미지의 크기를 조절할 수 있습니다.

**2. 리스트 형식의 게임 항목을 표시할 때:**
```
<com.quessr.playstore_gameview.GameListView
    android:id="@+id/listChartGameListView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="30dp"
    app:cardType="list"
    app:categoryTitleVisibility="visible"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@id/title"
    app:spanCount="3" />
```
- 옵션: cardType="list"로 설정하여 리스트 형식의 게임 항목을 표시합니다.
- spanCount 옵션을 통해 가로의 줄 수를 조정할 수 있습니다.

**3. SmallImageItem을 사용하여 작은 이미지를 활용한 게임 항목을 표시할 때:**
```
<com.quessr.playstore_gameview.GameListView
    android:id="@+id/smallImageGameListView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="30dp"
    app:cardType="small_image"
    app:categoryTitleVisibility="visible"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@id/title" />
```
- 옵션: cardType="small_image"로 설정하여 작은 이미지를 사용한 게임 항목을 간략하게 표현할 수 있습니다.

**4. BigImageFeaturedItem을 사용하여 큰 이미지를 강조할 때:**
```
<com.quessr.playstore_gameview.GameListView
    android:id="@+id/bigImageFeaturedGameListView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:cardType="big_featured_image"
    app:categoryTitleVisibility="visible"
    app:imageViewSize="big"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```
- 옵션: cardType="big_featured_image"으로 설정하여 큰 이미지로 주요 게임 정보를 강조합니다.
- imageViewSize 옵션을 통해 이미지 크기를 조절할 수 있습니다.# PlayStoreGameView

## 커스텀뷰를 활용한 구글 플레이 게임탭 UI 구현 데모

<img src="https://github.com/user-attachments/assets/ced75027-5480-4ee4-af09-9576b383bb12" alt="PlayStoreGameView" width="260" />
