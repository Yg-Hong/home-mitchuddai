<script setup>
import { reactive, toRaw } from "vue";
import { useRouter } from "vue-router";
import "@vueup/vue-quill/dist/vue-quill.snow.css";
import QnaEditForm from "@/components/QnaForm/QnaEditForm.vue";

const router = useRouter();

const formState = reactive({
  title: "",
  userId: "",
  userName: "",
  content: "",
});

const wrapperCol = {
  span: 14,
};

const updateContent = (value) => {
  console.log(value);
  formState.content = value;
};

const onSubmit = () => {
  console.log("submit!", toRaw(formState));
};

const onCancel = () => {
  console.log("cancel!");
  router.go(-1);
};
</script>

<template>
  <a-form :model="formState" :label-col="labelCol" :wrapper-col="wrapperCol">
    <a-row class="rowForInputBox">
      <a-col :span="6">
        <label class="NexonFootballGothicLight" for="inputBoxForTitle">제목</label>
      </a-col>
      <a-col :span="18">
        <a-input id="inputBoxForTitle" v-model:value="formState.title" />
      </a-col>
    </a-row>
    <a-row class="rowForInputBox">
      <a-col :span="6">
        <label class="NexonFootballGothicLight" for="inputBoxForUserName">사용자 이름</label>
      </a-col>
      <a-col :span="6">
        <a-input id="inputBoxForUserName" v-model:value="formState.userName" disabled />
      </a-col>
    </a-row>
    <a-row class="rowForInputBox">
      <a-col :span="6">
        <label class="NexonFootballGothicLight" for="inputBoxForUserId">사용자 아이디</label>
      </a-col>
      <a-col :span="6">
        <a-input id="inputBoxForUserId" v-model:value="formState.userId" disabled />
      </a-col>
    </a-row>

    <QnaEditForm @updateContent="updateContent" />

    <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button class="submitBox" @click="onSubmit">Create</a-button>
      <a-button style="margin-left: 10px" @click="onCancel">Cancel</a-button>
    </a-form-item>
  </a-form>
</template>

<style scoped>
.rowForInputBox {
  margin-bottom: 10px;
}

.submitBox {
  background-color: #002266;
  color: white;
}
</style>
