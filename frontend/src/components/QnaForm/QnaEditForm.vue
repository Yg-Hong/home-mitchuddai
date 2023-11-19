<script>
import { QuillEditor } from "@vueup/vue-quill";
import { reactive } from "vue";
import debounce from "lodash/debounce";

import "@vueup/vue-quill/dist/vue-quill.snow.css";

export default {
  components: {
    QuillEditor,
  },
  data() {
    return {
      content: reactive(""),
    };
  },
  props: {
    EditableFlag: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    editor() {
      return null;
    },
  },
  mounted() {
    console.log("this is Quill instance:", this.editor);
  },
  watch: {
    content: debounce(function (val) {
      //   console.log("content changed", val);
      this.$emit("updateContent", val);
    }, 100),
  },
};
</script>

<template>
  <div class="editorTextBox">
    <QuillEditor
      :theme="snow"
      :toolbar="essential"
      :readOnly="EditableFlag"
      v-model:content="content"
      contentType="html"
      @update:content="onEditorContentChange"
    />
  </div>
</template>

<style scoped>
.editorTextBox {
  margin-bottom: 50px;
  height: 400px;
}
</style>
