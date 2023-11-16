<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref } from "vue";
import CommentForm from "@/components/CommentForm/CommentForm.vue";

const route = useRoute();
const router = useRouter();

const house = ref({
  aptCode: 11110000000042,
  buildYear: "2000",
  roadName: "자하문로 33길",
  roadNameBonbun: 43,
  dongCode: 1111010100,
  apartment: "청운현대",
  lng: 126.970672,
  lat: 37.586305,
  area: 84.82,
  sidoName: "서울특별시",
  gugunName: "종로구",
  dongName: "청운동",
});

console.log(route.params.dongCode + " " + route.params.aptCode);

const onClickTobackToTheList = () => {
  console.log("뒤로가기");
  router.push(`/house/${route.params.dongCode}`);
};
</script>

<template>
  <br />

  <a-row justify="start">
    <span @click="onClickTobackToTheList"> &lArr; 목록으로 </span>
  </a-row>
  <a-row justify="center">
    <div>실거래 상세 자료</div>
  </a-row>
  <div class="detailInfoBox">
    <a-row>
      <a-col :span="24">기본정보</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 건물명 </a-col>
      <a-col :span="12">{{ house.apartment }}</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 주소 : </a-col>
      <a-col :span="12">{{ house.sidoName }} {{ house.gugunName }} {{ house.dongName }}</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 상세주소 : </a-col>
      <a-col :span="12">{{ house.roadName }} {{ house.roadNameBonbun }}</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 면적 </a-col>
      <a-col :span="12">{{ house.area }} m2</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 건축년도 </a-col>
      <a-col :span="12">{{ house.buildYear }} 년</a-col>
    </a-row>
  </div>
  <div>
    <a-row justify="start"> 거래가 비교 통계 그래프 </a-row>
  </div>
  <div>
    <a-row justify="start"> 주변 편의시설(도보) </a-row>
    <a-row class="space_evenly_box">
      <a-col :span="8"><a-row justify="center">편의점</a-row></a-col>
      <a-col :span="8"><a-row justify="center">약국</a-row></a-col>
    </a-row>
    <a-row class="space_evenly_box">
      <a-col :span="8"><a-row justify="center">은행</a-row></a-col>
      <a-col :span="8"><a-row justify="center">병원</a-row></a-col>
    </a-row>
    <a-row class="space_evenly_box">
      <a-col :span="8"><a-row justify="center">카페</a-row></a-col>
      <a-col :span="8"><a-row justify="center">마트</a-row></a-col>
    </a-row>
    <a-row class="space_evenly_box">
      <a-col :span="8"><a-row justify="center">편의점</a-row></a-col>
      <a-col :span="8"><a-row justify="center">주유소</a-row></a-col>
    </a-row>
  </div>
  <div>
    <a-row justify="start">댓글</a-row>
    <CommentForm />
  </div>
</template>

<style scoped>
.space_evenly_box {
  display: flex;
  justify-content: space-evenly;
}
</style>
