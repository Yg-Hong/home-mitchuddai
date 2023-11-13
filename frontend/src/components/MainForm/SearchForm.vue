<script setup>
import { ref, watch } from "vue";
import LocationAPI from "@/api/LocationAPI.js";

const livingType = ref("");

const sidoCode = ref("");
const gugunCode = ref("");
const dongCode = ref("");

const sidoList = ref([]);
const gugunList = ref([]);
const dongList = ref([]);

const getSidoList = () => {
  LocationAPI.getSidoList(
    ({ data }) => {
      sidoList.value = data;
    },
    () => {
      console.log("시도정보 조회에 실패하였습니다.");
    }
  );
};

const getGugunList = () => {
  LocationAPI.getGugunList(
    sidoCode.value,
    ({ data }) => {
      gugunList.value = data;
    },
    () => {
      console.log("구군정보 조회에 실패하였습니다.");
    }
  );
};

const getDongList = () => {
  LocationAPI.getDongList(
    gugunCode.value,
    ({ data }) => {
      dongList.value = data;
    },
    () => {
      console.log("동정보 조회에 실패하였습니다.");
    }
  );
};

getSidoList();

watch(sidoCode, async () => {
  getGugunList();
});

watch(gugunCode, async () => {
  getDongList();
});
</script>

<template>
  <a-row class="content">
    <a-col :span="18">
      <a-row justify="end">
        <a-flex :vertical="true">
          <a-row justify="space-between" class="upper_row">
            <a-col :span="5">
              <input
                type="radio"
                id="apartment"
                value="apartment"
                class="radio_input"
                v-model="livingType"
              />
              <label for="apartment" class="radio-label">아파트</label>
            </a-col>
            <a-col :span="5">
              <input
                type="radio"
                id="officetel"
                value="officetel"
                class="radio_input"
                v-model="livingType"
              />
              <label for="officetel" class="radio-label">오피스텔</label>
            </a-col>
            <a-col :span="5">
              <input
                type="radio"
                id="studio"
                value="studio"
                class="radio_input"
                v-model="livingType"
              />
              <label for="studio" class="radio-label">원룸</label>
            </a-col>
            <a-col :span="5">
              <input
                type="radio"
                value="Imdae"
                class="radio_input"
                v-model="livingType"
              />
              <label for="one" class="radio-label">임대</label>
            </a-col>
          </a-row>
          <a-row justify="space-between" class="lower_row">
            <a-col :span="6">
              <a-select
                ref="select"
                v-model:value="sidoCode"
                class="select_box"
                show-search
                placeholder="시도선택"
                @focus="focus"
                @change="handleChange"
              >
                <a-select-option v-for="sido in sidoList" :key="sido.code">{{
                  sido.name
                }}</a-select-option>
              </a-select>
            </a-col>
            <a-col :span="6">
              <a-select
                ref="select"
                v-model:value="gugunCode"
                class="select_box"
                show-search
                placeholder="구군선택"
                @focus="focus"
                @change="handleChange"
              >
              </a-select>
            </a-col>
            <a-col :span="6">
              <a-select
                ref="select"
                v-model:value="dongCode"
                class="select_box"
                show-search
                placeholder="동선택"
                @focus="focus"
                @change="handleChange"
              >
              </a-select>
            </a-col>
          </a-row>
        </a-flex>
      </a-row>
    </a-col>
    <a-col :span="6">
      <button class="search_button">검색하기</button>
    </a-col>
  </a-row>
</template>

<style scoped>
.content {
  width: 100%;
  height: 300px;
  background-color: blanchedalmond;
  align-items: center;
  display: flex;
  justify-content: center;
}

.radio_input {
  display: none;
}

.upper_row {
  /* 사이즈 */
  height: 35px;
  width: 600px;

  /* 패딩 */
  margin-bottom: 20px;
}

.lower_row {
  /* 사이즈 */
  height: 35px;
  width: 600px;
}

.radio-label {
  /* 사이즈 */
  height: 35px;

  /* 정렬 */
  display: flex;
  justify-content: center;
  align-items: center;

  /* 테두리 */
  border: 1px solid black;
  border-radius: 3px;

  /* 마진 */
  margin-left: 3px;
  margin-right: 3px;
}

.radio-label:hover {
  background-color: black;
}

.select_box {
  width: 160px;
}

.search_button {
  /* 마진 */
  margin-left: 15px;

  /* 사이즈 */
  height: 90px;

  /* 테두리 */
  border-radius: 3px;
}
</style>
