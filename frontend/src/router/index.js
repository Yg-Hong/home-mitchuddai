import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("@/views/MainView.vue"),
      children: [
        {
          path: "",
          component: () => import("@/components/MainForm/MainForm.vue"),
        },
        {
          path: "qna",
          component: () => import("@/components/QnaForm/QnaForm.vue"),
          children: [
            {
              path: "",
              component: () => import("@/components/QnaForm/QnaList.vue"),
            },
            {
              path: `:id`,
              component: () => import("@/components/QnaForm/QnaDetail.vue"),
            },
            {
              path: "write",
              component: () => import("@/components/QnaForm/QnaWrite.vue"),
            },
          ],
        },
      ],
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AboutView.vue"),
    },
    {
      path: "/login",
      name: "login",
      component: () => import("@/views/LoginView.vue"),
      children: [
        {
          path: "",
          component: () => import("@/components/LoginForm/LoginRightForm.vue"),
        },
        {
          path: "register",
          component: () => import("@/components/LoginForm/RegisterForm.vue"),
        },
        {
          path: "findPw",
          component: () => import("@/components/LoginForm/findPwForm.vue"),
        },
      ],
    },
  ],
});

export default router;
