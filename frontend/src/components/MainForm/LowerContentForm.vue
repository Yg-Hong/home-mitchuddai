<script setup>
import NewsContent from "@/components/MainForm/NewsContent.vue";
import BoardContent from "@/components/MainForm/BoardContent.vue";
import YoutubeContent from "./YoutubeContent.vue";
</script>

<template>
  <div class="LowerContent">
    <a-carousel autoplay>
      <div>
        <h3>뉴스</h3>
        <NewsContent />
      </div>
      <div>
        <h3>유튜브</h3>
        <a-row justify="space-around">
          <a-col :span="10">
            <YoutubeContent src="https://www.youtube.com/watch?v=PCXOh-LhkaA" />
          </a-col>
          <a-col :span="10">
            <YoutubeContent src="https://www.youtube.com/watch?v=lssPaAF_E9o&t=1s" />
          </a-col>
        </a-row>
      </div>
      <div>
        <h3>공지사항</h3>
        <BoardContent />
      </div>
    </a-carousel>
  </div>
</template>

<style scoped>
.LowerContent {
  height: 500px;
}
/* For demo */
:deep(.slick-slide) {
  text-align: center;
  height: 500px;
  line-height: 160px;
  background: #364d79;
  overflow: hidden;
}
:deep(.slick-slide h3) {
  color: #fff;
}
</style>
