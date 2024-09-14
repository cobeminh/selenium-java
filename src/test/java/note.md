
**I. Các câu lệnh sử dụng trong selenium**

Trước khi viết testcase bằng selenium webdrive bạn nên tìm hiểu các câu lệnh của selenium IDE. Nếu bạn sử dụng ngôn ngữ java để viết testcase bạn sẽ thấy các câu lệnh trong Selenium Webdrive là sự kết hợp các phương thức  của  selenium IDE , javascript and java.

Ví dụ: 
```
drive.findElement(By.name(“email”)).sendKeys(sUserName);
```

# **1: Các câu lệnh trình duyệt**

Selenium webdrive có một số các câu lệnh thao tác với trình duyệt như mở, đóng, lấy tiêu đề của trang web như dưới đây :

# **Câu lệnh [Get]**

**Mục đích** : Câu lệnh này sử dụng để mở một trang web mới trong trình duyệt hiện tại.

**Cú pháp**: ```drive.get(URL);```

**URL**: Là url để tải trang, nên sử dụng một url đầy đủ

Ví dụ: ```driver.get("wwww.google.com");```

# **Câu lệnh lấy tiêu đề [getTitle]**

**Mục đích** : Câu lệnh này sử dụng để lấy tiêu đề của trang web hiện tại

**Cú pháp**: ```driver.getTitle()```;

# **Câu lệnh lấy URL hiện tại [getCurrentUrl]**

**Mục đích**: Câu lệnh này dùng để lấy URL của trang hiện tại đã được tải trên trình duyệt.

**Cú pháp**: ```driver.getCurrentUrl()```;

# **Câu lệnh lấy source của trang web [getPageSource]**

**Mục đích**: Câu lệnh này dùng để lấy source của trang được tải cuối cùng.

**Cú pháp**: ```driver.getPageSource()```;

# **Câu lệnh đóng trang web [close]**

**Mục đích**: Câu lệnh này dùng để đóng cửa sổ hiện tại của trình duyệt.

**Cú pháp**: ```driver.close()```;

# **Câu lệnh thoát trình duyệt [quit]**

**Mục đích**: Câu lệnh này dùng để thoát khỏi trình duyệt và tất cả các cửa sổ đã mở.

**Cú pháp**: ```drive.quit()```;

# **Câu lệnh làm mới [refresh]**

**Mục đích**: Câu lệnh này dùng để làm mới trình duyệt hiện tại.

**Cú pháp**: ```driver.navigate().refresh()```;

# **2. Các câu lệnh WebElement**

Để tương tác với một trang web, cần phải xác định vị trí của phần tử trên trang web , Webdrive cung cấp 2 phương thức “Find Element” and “Find Elements” để xác định vị trí của phần tử trên trang web.

# **2.1. Phương thức “Find Element” và “Find Elements”**

Sự khác nhau giữa phương thức “Find Element” và  “Find Elements” là trả về đối tượng WebElement, nếu không ném một ngoại lệ và trả về một danh sách WebElement, có thể sẽ trả về danh sách rỗng nếu không cố phần tử DOM phù hợp với truy vấn(query). Phương thức “Find” lấy vị trí hoặc đối tượng truy vấn gọi bằng phương thức “By”

# **Tìm phần từ bằng ID (By ID)**

**Mục đích** : Tìm vị trí của phần tử bằng ID, nếu tìm được id phù hợp sẽ trả về vị trí của phần tử, nếu không có phần từ phù hợp với id sẽ xuất hiện NoSuchElementException

**Cú pháp** : ```driver.findElement(By.id(""))```;

Ví dụ: _```<input id="Email"></input>```_

```WebElement element=driver.findElement(By.id("Email"));```

# **Tìm phần tử bằng Name (By Name)**

**Mục đích** : Tìm vị trí của phần tử bằng name, nếu tìm được giá trị thuộc tính name phù hợp sẽ trả về vị trí của phần tử, nếu không có phần từ phù hợp với thuộc tính name sẽ xuất hiện NoSuchElementException.

**Cú pháp** : ```driver.findElement(By.name(""));```

Ví dụ: _```<input id="UserID"name="hien"></input>```_

```WebElement element=driver.findElement(By.name("hien"));```

# **Tìm phần tử bằng Class Name (className)**

**Mục đích** : Tìm phần tử dựa trên giá trị của thuộc tính “class”.

**Cú pháp** : ```driver.findElement(By.className(""));```

Ví dụ: _```<input class = “test”></input>```_

```WebElement elemen_t=driver.findElement(By.className("test"));```

# **Tìm phần tử bằng Tag Name (tagName)**

**Mục đích** : Tìm phần tử dựa vào tag names

**Cú pháp** : ```driver.findElement(By.tagName(""));```

Ví dụ: 
```<dt><a href="select_tag.html">TagSelected</a></dt>```

```WebElement element=driver.findElement(By.tagName("dt"));```

# **Tìm phần tử bằng Link Text**

**Mục đích** : Bạn có thể tìm phần tử của thẻ a bằng tên của link ,

**Cú pháp** : ```driver.findElement(By.tagName(""));```

Ví dụ: _```<a href="link.html">NameoftheLink</a>```_

```WebElement element=driver.findElement(By.linkText("Name of the Link"));```

# **Tìm phần tử bằng một phần Link Text**

**Mục đích** : Bạn có thể tìm phần tử của thẻ a bằng một phần tên của link ,

**Cú pháp** : ```driver.findElement(By.partialLinkText(""));```

Ví dụ: _```<a href="link.html">NameoftheLink</a>_```

```WebElement element=driver.findElement(By.partialLinkText("Name of the Link"));```

# **3. Các câu lệnh chuyển hướng trình duyệt**

# **Câu lệnh To**
**Mục đích** : Lệnh này dùng để chuyển hướng đến trang web hoặc URL yêu cầu.

**Cú pháp** : ```driver.navigate().to(URL)```

Trong đó : URL : là url để tải trang, nên sử dụng url đầy đủ

Ví dụ : ```driver.navigate().to("http://www.gooogle.com");```

# **Câu lệnh Forward**

**Mục đích** : Lệnh này dùng để đi đến trang tiếp theo , giống với nút forward trên trình duyệt.

**Cú pháp** : ```driver.navigate().forward()```

# **Câu lệnh Back**

**Mục đích** : Lệnh này dùng để quay về trang trước , giống với nút back trên trình duyệt.

**Cú pháp** : ```driver.navigate().back()```

# **Câu lệnh Refresh**

**Mục đích** : Lệnh này dùng để làm mới trang hiện tại .

**Cú pháp** : ```driver.navigate().refresh()```

# **4. Câu lệnh switch**

Một số trang web có nhiều khung(frames) hoặc nhiều cửa sổ. Selenium WebDriver gán một alphanumeric id cho mỗi cửa sổ ngay khi đối tượng WebDriver được khởi tạo. alphanumeric id này gọi cửa sổ xử lý(window handle). Selenium sử dụng id duy nhất này để điều khiển nhiều cửa sổ.

# **Câu lệnh getWindowHandle**

**Mục đích** : Lệnh này dùng để lấy cửa sổ xử lý (window handle) của cửa sổ hiện tại.

**Cú pháp** : ```driver.getWindowHandle();```

Ví dụ :```String  handle= driver.getWindowHandle();```
//Trả về một chuỗi các chữ số của cửa sổ xử lý

**Câu lệnh getWindowHandles**

**Mục đích** : Lệnh này dùng để lấy cửa sổ xử lý (window handle) của tất cả các cửa sổ hiện tại.

**Cú pháp** : 
```
driver.getWindowHandles();
```

Ví dụ :```String  handle= driver.getWindowHandles();//Trả về một tập hợp của cửa sổ xử lý```

# **Câu lệnh Switch To Window**

**Mục đích** : Lệnh này dùng hỗ trợ di chuyển giữa tên của các cửa sổ bằng cách sử dụng phương thức “switchTo”.

**Cú pháp** : ```driver.switchTo().window("windowName");```

Hoặc
```
for (String handle : driver.getWindowHandles()) {

driver.switchTo().window(handle);

}
```
# **Câu lệnh SwitchTo Frame**

**Mục đích** : Webdrive hỗ trợ di chuyển giữa tên của các khung bằng cách sử dụng phương thức “switchTo”.

**Cú pháp **: ```driver.switchTo().frame("frameName");```

# **Câu lệnh SwitchTo PopUp**

**Mục đích** : Webdrive hỗ trợ di chuyển giữa tên của các pop-up bằng cách sử dụng phương thức “switchTo”. Sau khi mở ra một pop-up có thể truy cập các alert và nó sẽ trả về  alert đang được mở. Bạn có thể chấp nhận, từ chối , đọc nội dung alert hoặc có thể nhập nhắc nhở.

**Cú pháp** : ```driver.switchTo().alert();```

# **5. Các câu lệnh wait**

# **Câu lệnh ImplicitlyWait**

**Mục đích** : Đợi một thời gian nhất định trước khi ném một ngoại lệ khi không thể tìm thấy các phần tử trên trang web. Lưu ý rằng chờ đời ngầm luôn thực hiện trong suốt thời gian trình duyệt mở. Điều này có nghĩa tìm kiếm bất kỳ các phần tử nào trên trang có thể mất thời gian chờ đợi ngầm cho việc thiết lập câu lệnh này.

**Cú pháp** :

```drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);```

# **Câu lệnh FluentWait**

**Mục đích**: Xác định số lượng tối đa thời gian để chờ đợi một điều kiện. giống như tần suất để kiểm tra điều kiện xuất hiện. Hơn nữa, người dùng có thể cấu hình để loại bỏ việc chờ đợi bằng cách ném một ngoại lệ trong khi chờ đợi như là NoSuchElementExceptions.

**Cú pháp**:
```
Wait wait=newFluentWait(driver)

.withTimeout(30, SECONDS)

.pollingEvery(5, SECONDS)

.ignoring(NoSuchElementException.class);

```
# **Câu lệnh ExpectedConditions**

**Mục đích**: Một điều kiện hợp lý được mong đợi để giá trị cuối cùng không phải là null hoặc sai(false).

**Cú pháp**:
```
WebDriverWait wait = new WebDriverWait(driver, 10);

WebElement element  =wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
```
# **Câu lệnh PageLoadTimeout**

**Mục đích**: Thiết lập giá trị thời gian để chờ đợi cho trang web  hoàn thành tải(loadding) trước khi ném một lỗi.

**Cú pháp**: 
```
driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
```

# **Câu lệnh SetScriptTimeout**

**Mục đích**: Thiết lập giá trị thời gian chờ đợi một kịch bản(script) không đồng bộ để kết thúc việc thực hiện trước khi ném một lỗi. Nếu thời gian chờ là tiêu cực, sau đó kịch bản sẽ chạy vô hạn .

**Cú pháp**: 
```
driver.manage().timeouts().setScriptTimeout(100,SECONDS);
```

# **Câu lệnh Sleep**

**Mục đích**: Câu lệnh này hiếm khi được sử dụng vì nó luôn luôn buộc các trình duyệt chờ đợi một thời gian cụ thể. Nếu bạn sử dụng câu lệnh này bạn có thể xác định giá trị thời gian chờ đợi cao hơn nhiều khi bạn làm các trường hợp kiểm thử.

**Cú pháp**: 
```
thread.sleep(1000);
```

# **6: Các câu lệnh sử dụng trong CheckBox and Radio**

# **Phương thức By.id**

**Mục đích**: Mỗi radio và checkbox đều có một ID nếu bạn chỉ muốn nhấp vào radio hoặc checkbox mà không quan tâm đến giá trị của nó thì câu lệnh như dưới đây:

**Cú pháp** :
```
WebElement radioBtn = driver.findElement(By.id("LQ"));

RadioBtn.click();
```
# **Phương thức  isSelected**

**Mục đích**: Nếu bạn có 2 radio hoặc 2 checkbox . Radio/checkbox một cái được gán giá trị mặc định, và bạn muốn chọn radio hoặc checkbox khác . Với phương thức isSelected bạn có thể biết radio hay checkbox được chọn hay không.

**Cú pháp**:
```
List  oRadioButton = driver.findElements(By.name("Radio"));

boolean bValue = false;

//Câu lệnh này trả về True , trong trường hợp nút radio đầu tiên được chọn

bValue = oRadioButton.get(0).isSelected();

//Câu lệnh này sẽ kiểm tra nếu bValue là True có nghĩa rằng nút radio đầu tiên được chọn

if(bValue = true){

//Câu lệnh này sẽ chọn nút radio thứ 2, nếu nút radio đầu tiên được chọn mặc định

oRadioButton.get(1).click();

}else{

//Nếu nút radio đầu tiên không được chọn mặc định thì nút radio đầu tiên sẽ được chọn

oRadioButton.get(0).click();

}
```
# **Phương thức value**

**Mục đích** : Chọn nút Radio hoặc checkbox với giá trị của chúng

**Cú pháp**:
```
//Tìm checkbox hoặc nút radio bằng tên(Name)

List oCheckBox = driver.findElements(By.name("eRadio"));

//Câu lệnh lấy số checkboxes hiện tại

int iSize = oCheckBox.size();

//Bắt đầu vòng lặp từ checkbox đầu tiên đến checkbox cuối cùng

for(int i=0; i < iSize ; i++ ){

//Lưu tên checkbox là một chuỗi , sử dụng thuộc tính Value

String sValue = oCheckBox.get(i).getAttribute("value");

//Chọn checkbox nếu giá trị của các checkbox giống nhau

if (sValue.equalsIgnoreCase("toolsqa")){

oCheckBox.get(i).click();

// Thoát khỏi vòng lặp

break;

}

}
```
# **Phương thức CssSelector**

**Mục đích** : Lựa chọn một radido hoặc checkbox bằng cách sử dụng giá trị của nó

**Cú pháp**:
```
WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='eRadio']"));

oCheckBox.click();
```
**Video minh họa **

Trong video này mình sẽ demo các câu lệnh được trình bày ở trên , mời các bạn theo dõi để hiểu hơn về cách sử dụng các câu lệnh , trang web mình sử dụng để demo là http://www.vietjetair.com/Sites/Web/vi-VN/Home

https://www.youtube.com/watch?v=pSe91WTC47k

Trên đây là một số các câu lệnh hay được sử dụng trong selenium Webdrive. Để có những testcase rõ ràng, ngắn gọn, hữu ích cần phải biết kết hợp nhuần nhuyễn những câu lệnh trong ngôn ngữ lập trình java với các câu lệnh của selenium Webdrive.``