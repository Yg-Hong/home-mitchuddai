<script setup>
import { toRaw, defineProps, watch, watchEffect, onMounted, ref, onBeforeMount } from "vue";

const props = defineProps({
  MarkerList: Object,
});

// 스크립트가 로딩되면 지도를 띄워주자!
// 즉, dom이 구성된 후에 실행되어야 하므로 mounted hook(onMounted)에서 실행
// 이 과정에서 kakao라는 객체는 window 객체 즉 전역에 등록
// 따라서, mount가 될 때마다 여러 번 로딩할 필요가 없다
// window 객체에 kakao가 등록되어 있는지 확인하고 없을 때만 loading
onMounted(() => {
  if (window.kakao?.map) {
    console.log(`KakaoMapComp.vue - 이미 map 있음`, window.kakao.map);
    initMap();
  } else {
    console.log(`KakaoMapComp.vue - map script loading 필요`);
    loadScript();
  }
});

const loadScript = () => {
  const key = import.meta.env.VITE_KAKAO_MAP_API_KEY;
  const script = document.createElement("script");
  // 동적 로딩을 위한 autoload=false 추가
  script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${key}`;
  // kakaomap script loading 후 initMap 실행
  script.addEventListener("load", () => kakao.maps.load(initMap));
  document.head.appendChild(script);
};

let map = null;
const initMap = () => {
  const container = document.getElementById("map");

  const options = {
    // center: new kakao.maps.LatLng(...centerLatLng),
    center: new kakao.maps.LatLng(37.586305, 126.970672),
    level: 5,
  };

  map = new kakao.maps.Map(container, options);
};

// const getMarkerPositions = () => {
//   console.log(props.MarkerList);
//   let markers = [];

//   for (marker in props.MarkerList) {
//     markers.push({
//       title: marker.apartmentName,
//       latlng: new kakao.maps.LatLng(...marker.latlng),
//     });
//   }

//   console.log("getMarkerPositions :" + markers);

//   return markers;
// };

const getMarkerPositions = () => {
  return [
    { title: "카카오", latlng: new kakao.maps.LatLng(33.450705, 126.570677) },
    { title: "생태연못", latlng: new kakao.maps.LatLng(33.450936, 126.569477) },
    { title: "텃밭", latlng: new kakao.maps.LatLng(33.450705, 126.570677) },
    { title: "근린공원", latlng: new kakao.maps.LatLng(33.451393, 126.570738) },
  ];
};

// 화면에 표시되어있는 marker들
const markers = [];

const displayMarkers = () => {
  // marker 정보 로딩
  const positions = getMarkerPositions();

  // 1. 현재 표시되어있는 marker들이 있다면 marker에 등록된 map을 없애준다.
  if (markers.length > 0) {
    markers.forEach((item) => {
      item.setMap(null);
    });
  }
  // 2. 마커 이미지 커스터마이징 하기
  // javascript 영역에서 assets의 정보 가져오기
  const imgSrc = "/src/assets/map/markerStar.png";
  const imgSize = new kakao.maps.Size(24, 35);
  const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);
  // 3. 마커 표시하기
  positions.forEach((position) => {
    const marker = new kakao.maps.Marker({
      map,
      position: position.latlng,
      title: position.title,
      image: markerImage,
    });
    markers.push(marker);
  });
  // 4. 지도를 이동시켜주기
  // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
  const bounds = positions.reduce(
    (bounds, position) => bounds.extend(position.latlng),
    new kakao.maps.LatLngBounds()
  );
  map.setBounds(bounds);
};

watch(props, () => {
  console.log("hmm..");
  console.log("(KakaoMapForm) " + props.MarkerList.value);
});

setTimeout(function () {
  displayMarkers();
}, 1000);
</script>

<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 1000px;
  height: 850px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
