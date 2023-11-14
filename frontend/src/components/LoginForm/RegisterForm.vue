<script setup>
import { reactive, computed } from "vue";
import { RouterLink } from "vue-router";
import { UserOutlined, LockOutlined, CaretRightOutlined } from "@ant-design/icons-vue";
import MemberAPI from "@/api/MemberAPI.js";

const formState = reactive({
  userId: "",
  userPassword: "",
  PasswordCheck: "",
  userName: "",
  emailId: "",
  emailDomain: "",
});

const onFinish = (values) => {
  console.log("Success: ", values);
};

const onFinishFailed = (errorInfo) => {
  console.log("Failed: ", errorInfo);
};

const disabled = computed(() => {
  return !(formState.userId && formState.userPassword);
});

const validateId = async (_rule, value) => {
  if (value === null || value === "") {
    return Promise.reject("아이디를 입력해주세요");
  } else {
    return Promise.resolve();
  }
};

const validatePass = async (_rule, value) => {
  if (value === null || value === "") {
    return Promise.reject("비밀번호를 입력해주세요");
  } else {
    return Promise.resolve();
  }
};

const checkPass = async (_rule, value) => {
  if (value !== formState.userPassword) {
    return Promise.reject("비밀번호가 일치하지 않습니다.");
  } else {
    return Promise.resolve();
  }
};

const rules = {
  duplicatedId: [
    {
      required: true,
      validator: validateId,
      trigger: "blur",
    },
  ],
  PasswordCheck: [
    {
      validator: checkPass,
      trigger: "change",
    },
  ],
};

const Register = () => {
  console.log("로그인 버튼 클릭");

  const user = {
    userId: formState.userId,
    userPassword: formState.userPassword,
  };

  MemberAPI.tryRegister(
    user,
    ({ data }) => {
      console.log("회원가입 성공 Id: " + data.userId + " | password" + data.userPassword);
    },
    () => {
      console.log("로그인 실패");
    }
  );
};
</script>

<template>
  <div class="NexonFootballGothicBold FontM FontColorB">회원가입</div>
  <a-form
    :model="formState"
    :rules="rules"
    name="normal_login"
    class="login-form"
    @finish="onfinish"
    @finishFailed="onfinishFailed"
  >
    <a-row justify="space-between" class="input_row">
      <a-col :span="5">
        <label for="normal_login_userId" class="NexonFootballGothicLight"> 아이디 : </label>
      </a-col>
      <a-col :span="19">
        <a-form-item name="userId" :rules="[{ requried: true, messgae: '아이디를 입력해주세요!' }]">
          <a-input v-model:value="formState.userId" placeholder="ID" class="InputBox">
            <template #prefix>
              <UserOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>
      </a-col>
    </a-row>

    <a-row justify="space-between" class="input_row">
      <a-col :span="5">
        <label for="normal_login_userPassword" class="NexonFootballGothicLight"> 비밀번호 : </label>
      </a-col>
      <a-col :span="19">
        <a-form-item
          name="userPassword"
          :rules="[{ required: true, message: '비밀번호를 입력해주세요!' }]"
        >
          <a-input-password
            v-model:value="formState.userPassword"
            placeholder="Password"
            class="InputBox"
          >
            <template #prefix>
              <LockOutlined class="site-form-item-icon" />
            </template>
          </a-input-password>
        </a-form-item>
      </a-col>
    </a-row>

    <a-row justify="space-between" class="input_row">
      <a-col :span="5">
        <label for="normal_login_PasswordCheck" class="NexonFootballGothicLight">
          비밀번호 확인 :
        </label>
      </a-col>
      <a-col :span="19">
        <a-form-item has-feedback name="PasswordCheck">
          <a-input
            v-model:value="formState.PasswordCheck"
            type="password"
            class="InputBox"
            autocomplete="off"
          >
            <template #prefix>
              <LockOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>
      </a-col>
    </a-row>

    <a-row justify="space-between" class="input_row">
      <a-col :span="5">
        <label for="normal_login_userName" class="NexonFootballGothicLight"> 이름 : </label>
      </a-col>
      <a-col :span="19">
        <a-form-item name="userName" :rules="[{ requried: true, messgae: '이름을 입력해주세요!' }]">
          <a-input v-model:value="formState.userName" placeholder="이름" class="InputBox">
            <template #prefix>
              <UserOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>
      </a-col>
    </a-row>

    <a-row justify="space-between" class="input_row">
      <a-col :span="5">
        <label for="normal_login_userEmail" class="NexonFootballGothicLight"> 이메일 : </label>
      </a-col>
      <a-col :span="9">
        <a-form-item
          name="userEmail"
          :rules="[{ requried: true, messgae: '이메일을 입력해주세요!' }]"
        >
          <a-input v-model:value="formState.userEmail" placeholder="이메일" class="InputBox">
            <template #prefix>
              <UserOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>
      </a-col>
      <a-col :span="1">
        <span class="NexonFootballGothicLight FontMS">@</span>
      </a-col>
      <a-col :span="9">
        <a-select
          ref="select"
          v-model:value="formState.emailDomain"
          class="select_box"
          show-search
          placeholder="도메인"
          @focus="focus"
          @change="handleChange"
        >
          <a-select-option key="gmail.com"> gmail.com </a-select-option>
        </a-select>
      </a-col>
    </a-row>

    <a-row justify="end">
      <a-form-item>
        <a-button
          :disabled="disabled"
          class="login-form-button"
          id="login-form-button"
          @click="Register"
        >
          <span>회원가입 </span> <CaretRightOutlined />
        </a-button>
      </a-form-item>
    </a-row>
  </a-form>

  <a-flex :vertical="true" class="login-form-footer" justify="end">
    <a-row justify="space-between">
      <a-col :span="12">
        <router-link to="/login">
          <span class="NexonGothicBold FontColorC">로그인 하기</span>
        </router-link>
      </a-col>
    </a-row>
  </a-flex>
</template>

<style scoped>
#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-button {
  width: 100px;
}

.input_row {
  align-items: center;
}
.InputBox {
  height: 40px;
}

.select_box {
  width: 140px;
  height: 40px;
}

.duplicated_id_btn {
  height: 50px;
  width: 80px;
}

#login-form-button {
  background-color: #002266;
  color: #ffffff;

  height: 40px;
  width: 100px;
}

#login-form-button:hover {
  background-color: #00387e;
}

.login-form-footer {
  margin-top: 80px;

  border-top: 1px solid;
}
</style>
