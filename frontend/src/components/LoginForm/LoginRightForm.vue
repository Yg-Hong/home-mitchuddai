<script setup>
import { reactive, computed } from "vue";
import {
  UserOutlined,
  LockOutlined,
  CaretRightOutlined,
} from "@ant-design/icons-vue";

const formState = reactive({
  userId: "",
  password: "",
  remeber: true,
});

const onFinish = (values) => {
  console.log("Success: ", values);
};

const onFinishFailed = (errorInfo) => {
  console.log("Failed: ", errorInfo);
};

const disabled = computed(() => {
  return !(formState.userId && formState.password);
});
</script>

<template>
  <a-col :span="8">
    <div class="right">
      <div class="NexonFootballGothicBold FontL FontColorA">
        Home Mitchuddai
      </div>
      <div class="NexonFootballGothicBold FontM FontColorB">
        로그인 해주세요.
      </div>
      <a-form
        :model="formState"
        name="normal_login"
        class="login-form"
        @finish="onfinish"
        @finishFailed="onfinishFailed"
      >
        <a-form-item
          name="userId"
          :rules="[{ requried: true, messgae: 'Please input yout user ID!' }]"
        >
          <a-input
            v-model:value="formState.userId"
            placeholder="ID"
            class="InputBox"
          >
            <template #prefix>
              <UserOutlined class="site-form-item-icon" />
            </template>
          </a-input>
        </a-form-item>

        <a-form-item
          name="password"
          :rules="[{ required: true, message: 'Please input your password!' }]"
        >
          <a-input-password
            v-model:value="formState.password"
            placeholder="Password"
            class="InputBox"
          >
            <template #prefix>
              <LockOutlined class="site-form-item-icon" />
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item>
          <a-row justify="space-between">
            <a-col :span="6">
              <a-form-item name="remember" no-style>
                <a-checkbox
                  v-model:checked="formState.remember"
                  class="NexonGothicBold FontColorA"
                  >아이디 저장
                </a-checkbox>
              </a-form-item>
            </a-col>
            <a-col span="6">
              <a-row justify="end">
                <a class="NexonGothicBold FontColorC" href="">비밀번호 찾기</a>
              </a-row>
            </a-col>
          </a-row>
        </a-form-item>

        <a-row justify="end">
          <a-form-item>
            <a-button
              :disabled="disabled"
              html-type="submit"
              class="login-form-button"
              id="login-form-button"
            >
              <span>Log in </span> <CaretRightOutlined />
            </a-button>
          </a-form-item>
        </a-row>
      </a-form>

      <a-flex :vertical="true" class="login-form-footer" justify="end">
        <a-row justify="space-between">
          <a-col :span="12"
            ><a class="NexonGothicBold FontColorC" href="">회원가입 하기</a>
          </a-col>
        </a-row>
      </a-flex>
    </div>
  </a-col>
</template>

<style scoped>
.right {
  width: 100%;
  height: 100%;

  flex-direction: column;
  align-content: center;
}

#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-button {
  width: 100px;
}

.InputBox {
  height: 50px;
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
