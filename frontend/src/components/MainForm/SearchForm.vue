<script setup></script>

<template>
  <div class="content">
    <a-row justify="space-between">
      <a-radio-group v-model:value="value1" button-style="solid">
        <a-radio-button value="apartment">아파트 </a-radio-button>
        <a-radio-button value="a">원룸 </a-radio-button>
        <a-radio-button value="a">오피스텔</a-radio-button>
        <a-radio-button value="a">아파트 </a-radio-button>
      </a-radio-group>
    </a-row>
    <a-row justify="space-between">asdf</a-row>
  </div>
</template>

<style scoped>
.content {
  height: 300px;
  background-color: blanchedalmond;
  align-items: center;
  display: flex;
  justify-content: center;
}
</style>
