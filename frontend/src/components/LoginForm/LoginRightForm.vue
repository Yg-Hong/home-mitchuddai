<script setup>
import { reactive, computed } from "vue";

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
      <div class="fontA">로그인</div>
      <a-form
        :model="formState"
        name="normal_login"
        class="login-form"
        @finish="onfinish"
        @finishFailed="onfinishFailed"
      >
        <a-form-item
          label="userId"
          name="userId"
          :rules="[{ requried: true, messgae: 'Please input yout user ID!' }]"
        >
          <a-input v-model:value="formState.userId">
            <template #prefix>
              <UserOutlined class="site-form0-item-icon" />
            </template>
          </a-input>
        </a-form-item>

        <a-form-item
          label="Password"
          name="password"
          :rules="[{ required: true, message: 'Please input your password!' }]"
        >
          <a-input-password v-model:value="formState.password">
            <template #prefix>
              <LockOutlined class="site-fiorm-item-icon" />
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item>
          <a-form-item name="remember" no-style>
            <a-checkbox v-model:checked="formState.remember"
              >Remeber me</a-checkbox
            >
          </a-form-item>
          <a class="login-form-forgot" href="">Forgot Password</a>
        </a-form-item>

        <a-form-item>
          <a-button
            :disabled="disabled"
            type="primary"
            html-type="submit"
            class="login-form-button"
          >
            Log in
          </a-button>
          Or
          <a href="">register now!</a>
        </a-form-item>
      </a-form>
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
</style>
