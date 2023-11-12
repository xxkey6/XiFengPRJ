const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    open: true, // 自动打开浏览器
    host: '0.0.0.0',
    port: 8080,
    https: false,
    // 使用代理
    proxy: {
      '/api/':{
        target: 'http://localhost:8888/xifengapp',
        changeOrigin: true, // 允许跨域
        pathRewrite:{
          '^/api/': ''
        }
      }
    }
  }
})

