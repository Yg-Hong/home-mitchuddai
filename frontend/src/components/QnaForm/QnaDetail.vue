<script setup>
import { reactive, toRaw, ref } from "vue";
import { useRouter } from "vue-router";
import "@vueup/vue-quill/dist/vue-quill.snow.css";
import QnaEditForm from "@/components/QnaForm/QnaEditForm.vue";

const router = useRouter();

const formState = reactive({
  no: "",
  title: "",
  userId: "",
  userName: "",
  content: "",
});

const EditableFlag = ref(true);

const wrapperCol = {
  span: 14,
};

const updateContent = (value) => {
  console.log(value);
  formState.content = value;
};

const onModify = () => {
  console.log("수정하기 API 호출!", toRaw(formState));
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
        <label class="NexonFootballGothicLight" for="inputBoxForTitle"
          >제목</label
        >
      </a-col>
      <a-col :span="18">
        <a-input id="inputBoxForTitle" v-model:value="formState.title" />
      </a-col>
    </a-row>
    <a-row class="rowForInputBox">
      <a-col :span="6">
        <label class="NexonFootballGothicLight" for="inputBoxForUserName"
          >사용자 이름</label
        >
      </a-col>
      <a-col :span="6">
        <a-input
          id="inputBoxForUserName"
          v-model:value="formState.userName"
          disabled
        />
      </a-col>
    </a-row>
    <a-row class="rowForInputBox">
      <a-col :span="6">
        <label class="NexonFootballGothicLight" for="inputBoxForUserId"
          >사용자 아이디</label
        >
      </a-col>
      <a-col :span="6">
        <a-input
          id="inputBoxForUserId"
          v-model:value="formState.userId"
          disabled
        />
      </a-col>
    </a-row>

    <QnaEditForm @updateContent="updateContent" :EditableFlag="EditableFlag" />

    <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button class="submitBox" @click="onModify">수정하기</a-button>
      <a-button class="submitBox" @click="onReply">답변 입력하기</a-button>
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
