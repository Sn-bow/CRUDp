// input 태그의 maxlength 보다 입력값이 커지게 되면 slice 메소드를 통해 잘라 4글자로 제한
function maxLengthCheck(object) {
  if (object.value.length > object.maxLength) {
    object.value = object.value.slice(0, object.maxLength);
  }
}

// document
const email = document.querySelector(".email");
const pwd = document.querySelector(".pwd");
const pwdCh = document.querySelector(".pwd-ch");
const name_ = document.querySelector(".name");
const but = document.querySelector(".signUpSubmit");
// err
const emailErr = document.querySelector(".emailErr");
const pwdErr = document.querySelector(".pwdErr");
const pwdChErr = document.querySelector(".pwdChErr");
const nameErr = document.querySelector(".nameErr");

// regexp
let emailReg = /[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;
let pwdReg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;

// state
let emailState = false;
let pwdState = false;
let pwdChState = false;
let nameState = false;
let phoneState = false;
let date = false;

// function
// button activate handler
const allCheckHandler = () => {
  if (emailState && pwdState && pwdChState && nameState) {
    but.disabled = false;
  } else {
    but.disabled = true;
  }
};

// email 체크 부분 작성 필요
const emailCheckHandler = (email) => {};

const emailRegHandler = (value) => {
  if (!emailReg.test(value)) {
    emailErr.innerText = "이메일 형식이 올바르지 않습니다.";
    emailState = false;
  } else {
    emailErr.innerText = "";
    emailState = true;
  }
  allCheckHandler();
};

let pwdValue = "";
const pwdRegHandler = (value) => {
  if (!pwdReg.test(value)) {
    pwdState = false;
    pwdErr.innerText =
      "비밀번호 형식은 영문,숫자,특수문자의 조합으로 8자이상 15자 이하여야 합니다.";
  } else {
    pwdErr.innerText = "";
    pwdState = true;
  }
  pwdValue = value;
  allCheckHandler();
};
// 비밀번호 재확인 부분 다시 해야함
const pwdCheckHandler = (value) => {
  if (value === "" || pwdValue != value) {
    pwdChState = false;
    pwdChErr.innerText = "비밀번호가 일치하지 않습니다.";
  } else {
    pwdChErr.innerText = "";
    pwdChState = true;
  }
  allCheckHandler();
};

const nameRegHandler = (value) => {
  if (value === "") {
    nameState = false;
    nameErr.innerText = "닉네임을 작성해주세요";
  } else {
    nameState = true;
    nameErr.innerText = "";
  }
  allCheckHandler();
};

// input class name
// email pwd pwd-ch name phone1 phone2 phone3 date signUpSubmit
// 해야할일
// 1. 이메일 검증
email.addEventListener("focusout", (e) => {
  emailRegHandler(e.target.value);
});
// 2. 비밀번호 검증
pwd.addEventListener("focusout", (e) => {
  pwdRegHandler(e.target.value);
});
// 3. 비밀번호 재확인
pwdCh.addEventListener("focusout", (e) => {
  pwdCheckHandler(e.target.value);
});
// 4. 이름 검증
name_.addEventListener("focusout", (e) => {
  nameRegHandler(e.target.value);
});
// 5. 전화번호 및 생일 체크했는지 확인
// 6. 모든 확인이 끝났으면 submit 버튼 활성화

// 버튼 css
but.addEventListener("mouseover", () => {
  but.setAttribute(
    "style",
    "transition: all 0.5s ease-in-out; cursor: pointer; color: white; background-color: rgb(50, 50, 50);"
  );
});
but.addEventListener("mouseout", () => {
  but.setAttribute(
    "style",
    "transition: all 0.5s ease-in-out; cursor: pointer; color: black; background-color: lightgray;"
  );
});
