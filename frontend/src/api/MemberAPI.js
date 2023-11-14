import { localAxios } from "@/utils/http-commons";

const MemberAPI = localAxios();

const tryLogin = (user, success, fail) => {
  MemberAPI.post("/Member/Login", user).then(success).catch(fail);
};

const tryRegister = (user, success, fail) => {
  MemberAPI.post("/Member/register", user).then(success).catch(fail);
};

const getMemberDetail = (success, fail) => {
  MemberAPI.get(`/detail/${id}`).then(success).catch(fail);
};

export default { tryLogin, tryRegister, getMemberDetail };
