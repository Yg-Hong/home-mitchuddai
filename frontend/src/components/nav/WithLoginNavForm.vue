<script setup>
import { BellOutlined } from "@ant-design/icons-vue";
</script>

<template>
  <div class="nav">
    <a-row>
      <a-col
        :span="5"
        class="nav_logo NexonFootballGothicBold FontM FontColorA item_align_center"
      >
        <router-link to="/">Home mitchuddai</router-link>
      </a-col>
      <a-col :span="10">
        <a-row
          justify="space-between"
          class="NexonFootballGothicBold FontMS FontColorA"
        >
          <router-link to="/">소개</router-link>
          <router-link to="/">뉴스</router-link>
          <router-link to="/">실거래가 조회</router-link>
          <router-link to="/">공지사항</router-link>
          <router-link to="/">Q&A</router-link>
        </a-row>
      </a-col>
      <a-col :span="8">
        <a-row justify="end" class="NexonFootballGothicBold FontMS FontColorA">
          <router-link to="/login">
            <BellOutlined />
          </router-link>
          <div class="margin_left">
            <router-link to="/">마이페이지</router-link>
          </div>
        </a-row>
      </a-col>
      <!-- <router-link></router-link> -->
    </a-row>
  </div>
</template>

<style scoped>
.nav {
  height: 75px;

  /* 상단 고정 */
  position: fixed;
  top: 0;
  left: 0;
  right: 0;

  border-bottom: 1px solid;

  /* display: flex;
  justify-content: space-between;
  align-items: center; */
}

/* .item_align_center {
  display: flex;
  flex-direction: column;
  justify-content: center;
} */

.navigation_list {
  align-items: center;
}

.margin_left {
  margin-left: 10px;
}

.anticon_bell {
  height: 20px;
  width: 20px;
}

a {
  color: black;
}

a:hover {
  color: #00387e;
}
</style>
