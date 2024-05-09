// xử lý sự kiện cho giao diện index.html
var name1;
var email;
let phone;
let message;

let def = "Hãy nhập vào thông tin";
let emp = "";

function setFirstTime() {
  window.document.nform.txtName.value = def;
  //document.nform.nform.txtName.value = def;

  document.forms[0].txtEmail.value = emp;

  document.getElementById("txtPhone").value = emp;

  document.querySelector("#txtMessage").value = def;
}

function getValues(fn) {
  name1 = fn.txtName.value;
  email = fn.txtEmail.value;
  phone = fn.txtPhone.value;
  message = fn.txtMessage.value;

  // biến xác nhận hợp lệ
  let validName = true;
  let validEmail = true;

  let notes = "";

  if (name1 == def || name1 == emp) {
    validName = false;
    notes = "Xin mời nhập thông tin.";
  } else {
    if (name1.length > 50 || name1.length < 5) {
      validName = false;
      notes = "Tên đày đủ cần trong khoảng 5-50 ký tự";
    
    }
  }
  // thông báo
  if(notes.trim()!=""){
    window.alert(notes);
    if(!validName){
        document.getElementById('txtName').focus();
    }
  }
  return validName;
}

function sendInfo(){
    if(this.getValues(fn)){
        fn.method="post";
        fn.action="";
        fn.submit();
    }
}
