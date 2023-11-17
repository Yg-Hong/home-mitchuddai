<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onBeforeMount } from "vue";
import CommentForm from "@/components/CommentForm/CommentForm.vue";
import CommentInputForm from "@/components/CommentForm/CommentInputForm.vue";
import HouseAPI from "@/api/HouseAPI.js";

const route = useRoute();
const router = useRouter();

const houseDetailInfo = ref({
  aptCode: 26110000000001,
  buildYear: 1998,
  roadName: "영주로",
  apartmentName: "동아(92-0)",
  jibun: "92",
  lng: "129.029977555653",
  lat: "35.1136527983158",
  sidoName: "부산광역시",
  gugunName: "중구",
  dongName: "영주동",
  houseDeals: [
    {
      no: 261102201000001,
      dealAmount: "23,400",
      dealYear: 2022,
      dealMonth: 1,
      area: "84.7",
      floor: "8",
      aptCode: 26110000000001,
    },
  ],
});

// const houseDetailInfo = ref({});

const getHouseDetail = () => {
  HouseAPI.getHouseDetail(
    route.params.dongCode,
    route.params.aptCode,
    ({ data }) => {
      console.log(data);
      houseDetailInfo.value = data;
    },
    () => {
      console.log("실거래 상세정보 조회에 실패하였습니다.");
    }
  );
};

const onClickTobackToTheList = () => {
  console.log("뒤로가기");
  router.push(`/house/${route.params.dongCode}`);
};

getHouseDetail();
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
      <a-col :span="6"> 건물명 : </a-col>
      <a-col :span="12">{{ houseDetailInfo.apartmentName }}</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 주소 : </a-col>
      <a-col :span="12"
        >{{ houseDetailInfo.sidoName }} {{ houseDetailInfo.gugunName }}
        {{ houseDetailInfo.dongName }}</a-col
      >
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 상세주소 : </a-col>
      <a-col :span="12">{{ houseDetailInfo.roadName }} {{ houseDetailInfo.roadNameBonbun }}</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 면적 </a-col>
      <a-col :span="12">{{ houseDetailInfo.area }} m2</a-col>
    </a-row>
    <a-row justity="space-between">
      <a-col :span="2"></a-col>
      <a-col :span="6"> 건축년도 </a-col>
      <a-col :span="12">{{ houseDetailInfo.buildYear }} 년</a-col>
    </a-row>
  </div>

  <div>
    <a-row justify="start"> 실거래 목록 </a-row>
  </div>
  <div>
    <a-row justify="start"> 실거래가 비교 통계 그래프 </a-row>
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
    <CommentInputForm />
  </div>
</template>

<style scoped>
.space_evenly_box {
  display: flex;
  justify-content: space-evenly;
}
</style>
