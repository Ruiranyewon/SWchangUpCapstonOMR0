package com.example.swchangupcapstonomr

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.swchangupcapstonomr.ui.theme.SWchangUpCapstonOMRTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SWchangUpCapstonOMRTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF8441), // 노랑
                        Color(0xFFFFFD8E),
                        Color(0xFFFF5064)  // 핑크
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "로그인", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            var id by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("아이디를 입력해 주세요") },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("비밀번호를 입력해 주세요") },
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // containerColor: 버튼 배경색, contentColor: 텍스트 색상
            Button(
                onClick = { /* 로그인 처리 */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000),
                    contentColor = Color.White
                )
            ) {
                Text("로그인")
            }

            var autoLoginChecked by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 4.dp)
            ) {
                RadioButton(
                    selected = autoLoginChecked,
                    onClick = { autoLoginChecked = !autoLoginChecked }
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "자동로그인")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 카카오 로그인 버튼 (노란색)
            Button(
                onClick = { /* 카카오 로그인 */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFE812)) // 카카오 노란색
            ) {
                Text("kakao로 로그인", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 구글 로그인 버튼 (흰 배경)
            OutlinedButton(
                onClick = { /* 구글 로그인 */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF))
            ) {
                Text("google로 로그인", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 페이스북 로그인 버튼 (파란색)
            Button(
                onClick = { /* 페이스북 로그인 */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2)) // Facebook 파란색
            ) {
                Text("facebook으로 로그인", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "이메일로 회원가입",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "|",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "회원가입",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    SWchangUpCapstonOMRTheme {
        LoginScreen()
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SWchangUpCapstonOMRTheme {
                FeedScreen()
            }
        }
    }
}

sealed class BottomNavItem(val label: String, val icon: ImageVector) {
    object Feed : BottomNavItem("Feed", Icons.Filled.List)
    object Target : BottomNavItem("Target", Icons.Filled.Star)
    object Home : BottomNavItem("Home", Icons.Filled.Home)
    object Cart : BottomNavItem("Cart", Icons.Filled.ShoppingCart)
    object MyPage : BottomNavItem("MyPage", Icons.Filled.Person)
}

@Composable
fun FeedScreen() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        BottomNavItem.Feed,
        BottomNavItem.Target,
        BottomNavItem.Home,
        BottomNavItem.Cart,
        BottomNavItem.MyPage
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (selectedItem) {
                0 -> FeedContent()
                1 -> TargetScreen()
                2 -> HomeScreen()
                3 -> CartScreen()
                4 -> ProfileScreen()
            }
        }
    }
}


@Composable
fun FeedPostCard(post: FeedPost) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .border(1.dp, Color(0xFFFFA726), shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF9F9F9) // light gray-white tone between 0xFFECECEC and 0xFFFFFFFF
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "유저 아이콘", modifier = Modifier.size(32.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = post.userName, style = MaterialTheme.typography.titleMedium)
                    Text(text = post.profile, style = MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = post.content, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = post.hashtags.joinToString(" "), style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.Info, contentDescription = "댓글 수", modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("${post.commentCount}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.weight(1f))
                Text(post.timeAgo, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun FeedContent() {
    val posts = listOf(
        FeedPost(
            userName = "홍길동",
            profile = "DSNW / 봄 웜 브라이트",
            content = "코랄 핑크와 딥 오렌지 립제품을 선물 받았는데, 퍼컬에 안 맞아서 고민입니다...",
            hashtags = listOf("#봄웜브라이트", "#봄메이크업", "#오렌지메이크업"),
            commentCount = 9,
            timeAgo = "25분전"
        ),
        FeedPost(
            userName = "김철수",
            profile = "OSNT / 겨울 쿨 딥 · 다크",
            content = "OSNT에서 지용성98%인 극 지용성인데, 피지관리 어떻게 해야 할까요?...",
            hashtags = listOf("#OSNT", "#지용성피부관리", "#민감성피부관리"),
            commentCount = 11,
            timeAgo = "1시간전"
        ),
        FeedPost(
            userName = "이민수",
            profile = "ORPW / 여름 쿨 브라이트 · ",
            content = "ORPW에서 지용성98%인 극 지용성인데, 피지관리 어떻게 해야 할까요?...",
            hashtags = listOf("#OSNT", "#지용성피부관리", "#민감성피부관리"),
            commentCount = 11,
            timeAgo = "1시간전"
        ),
        FeedPost(
            userName = "이민수",
            profile = "ORPW / 여름 쿨 브라이트 · ",
            content = "ORPW에서 지용성98%인 극 지용성인데, 피지관리 어떻게 해야 할까요?...",
            hashtags = listOf("#OSNT", "#지용성피부관리", "#민감성피부관리"),
            commentCount = 11,
            timeAgo = "2시간전"
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF7E00).copy(alpha = 0.65f), // 노랑
                        Color(0xFFFFFD8E).copy(alpha = 0.7f),
                        Color(0xFFFF695F).copy(alpha = 0.65f)  // 핑크
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "피드",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("검색") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "검색") },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = { /* TODO: 글쓰기 이동 처리 */ },
                        modifier = Modifier
                            .size(56.dp)
                            .background(Color.White, shape = RoundedCornerShape(12.dp))
                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Create,
                            contentDescription = "글쓰기",
                            tint = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))

                LazyColumn {
                    items(posts) { post ->
                        FeedPostCard(post = post)
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 8.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(50))
                        .background(Color.White, shape = RoundedCornerShape(50)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("?", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun TargetScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Target Screen")
    }
}

@Composable
fun CartScreen() {
    // 샘플 장바구니 데이터 (2개, 두 번째만 미선택)
    val cartItems = listOf(
        CartItem(true, "올리브영", "라네즈 립 슬리핑 마스크", 1, 18000, 13500),
        CartItem(false, "아리따움", "헤라 블랙쿠션", 1, 45000, 39000)
    )
    val totalPrice = cartItems.sumOf { it.originalPrice }
    val productDiscount = cartItems.sumOf { it.originalPrice - it.salePrice }
    val couponDiscount = 2000
    val shippingFee = 3000
    val finalPrice = totalPrice - productDiscount - couponDiscount + shippingFee

    var selectedItem by remember { mutableStateOf(3) } // Cart index
    val items = listOf(
        BottomNavItem.Feed,
        BottomNavItem.Target,
        BottomNavItem.Home,
        BottomNavItem.Cart,
        BottomNavItem.MyPage
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("장바구니", style = MaterialTheme.typography.headlineMedium)
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                // 전체선택/선택삭제 Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = false, onCheckedChange = {})
                        Text("전체선택(1/2)", style = MaterialTheme.typography.bodyMedium)
                    }
                    Text(
                        text = "선택삭제",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }
                Divider(color = Color.Black.copy(alpha = 0.6f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(12.dp))
                // Use LazyColumn with .weight(1f)
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    items(cartItems) { item ->
                        Column {
                            Text(
                                text = "판매업체 배송상품",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            CartItemCard(
                                checked = item.checked,
                                storeName = item.storeName,
                                productName = item.productName,
                                quantity = item.quantity,
                                originalPrice = item.originalPrice,
                                salePrice = item.salePrice
                            )
                            Divider(color = Color.Black.copy(alpha = 0.6f), thickness = 1.dp)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                CartSummary(
                    totalPrice = totalPrice,
                    productDiscount = productDiscount,
                    couponDiscount = couponDiscount,
                    shippingFee = shippingFee,
                    finalPrice = finalPrice
                )
            }
        }
    }
}
data class CartItem(
    val checked: Boolean,
    val storeName: String,
    val productName: String,
    val quantity: Int,
    val originalPrice: Int,
    val salePrice: Int
)
@Composable
fun CartItemCard(
    checked: Boolean,
    image: ImageBitmap? = null,
    storeName: String,
    productName: String,
    quantity: Int,
    originalPrice: Int,
    salePrice: Int
) {
    // Use rememberUpdatedState so the checkbox always reflects the external value
    val isChecked by rememberUpdatedState(checked)
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { /* handle check change here if needed */ },
                modifier = Modifier
                    .padding(end = 2.dp)
                    .align(Alignment.Top)
            )
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.LightGray)
                    .padding(end = 2.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("상품이미지")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .padding(vertical = 4.dp)
            ) {
                Text(text = storeName, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                Text(text = productName, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))

                // Quantity control row
                var currentQty by remember { mutableStateOf(quantity) }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color(0xFFFFA726), shape = RoundedCornerShape(50))
                            .clickable { if (currentQty > 1) currentQty-- },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("-", color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text("$currentQty", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color(0xFFFFA726), shape = RoundedCornerShape(50))
                            .clickable { currentQty++ },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("+", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${originalPrice}원",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${salePrice}원", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun CartSummary(
    totalPrice: Int,
    productDiscount: Int,
    couponDiscount: Int,
    shippingFee: Int,
    finalPrice: Int
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("예상 결제금액", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        SummaryRow("총 상품금액", totalPrice)
        SummaryRow("상품자체할인", -productDiscount)
        SummaryRow("쿠폰할인", -couponDiscount, showCouponButton = true)
        SummaryRow("배송비", shippingFee)

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFFFD767), Color(0xFFFF531F).copy(alpha = 0.7f), Color(0xFFFF531F).copy(alpha = 0.8f),Color(0xFFFF3E8C).copy(alpha = 0.7f))
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { /* 결제하기 */ },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${finalPrice}원 결제하기",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun SummaryRow(title: String, amount: Int, showCouponButton: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
        Row {
            if (showCouponButton) {
                TextButton(onClick = {}) {
                    Text("쿠폰 선택", color = Color(0xFFFF6F00))
                }
            }
            Text("${amount}원", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    SWchangUpCapstonOMRTheme {
        CartScreen()
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            val items = listOf(
                BottomNavItem.Feed,
                BottomNavItem.Target,
                BottomNavItem.Home,
                BottomNavItem.Cart,
                BottomNavItem.MyPage
            )
            var selectedItem by remember { mutableStateOf(2) }
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 광고 배너
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text("광고 or 추천 제품", style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 12개 카테고리 (3행 4열)
                val categories = listOf(
                    "기초케어", "선케어", "베이스 메이크업", "립 메이크업",
                    "아이 메이크업", "마스크 팩", "클렌징", "뷰티 소품",
                    "향수", "헤어케어", "바디케어", "네일"
                )

                for (row in 0 until 3) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        for (col in 0 until 4) {
                            val index = row * 4 + col
                            Box(
                                modifier = Modifier
                                    .size(70.dp)
                                    .border(2.dp, Color(0xFFFFA726), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("(${categories[index]})", style = MaterialTheme.typography.bodySmall, color = Color.DarkGray)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 추천 보기 배너 1
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFFFECB3), Color(0xFFFF8A65))
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "> 맞춤 메이크업 제품 추천 보러가기",
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 추천 보기 배너 2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFFFECB3), Color(0xFFFF8A65))
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "> 전문가가 추천하는 필승 화장 조합 보러가기",
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // 추천 보기 배너 3
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFFFECB3), Color(0xFFFF8A65))
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "> 나에게 꼭 맞는 기초 루틴 추천 받기",
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 채팅 상담 말풍선
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(50))
                            .background(Color.White, shape = RoundedCornerShape(50)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("?", color = Color.Black)
                    }
                }
            }
        }
    }
}


@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Profile Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SWchangUpCapstonOMRTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    SWchangUpCapstonOMRTheme {
        FeedScreen()
    }
}
data class FeedPost(
    val userName: String,
    val profile: String,
    val content: String,
    val hashtags: List<String>,
    val commentCount: Int,
    val timeAgo: String
)