<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"120rpx 40rpx 80rpx","background":"url(http://codegen.caihongy.cn/20230411/8618bc1c31c743f7810277b59089c976.jpg) no-repeat center top / 100% 100%,#fff","height":"100%"}'>
		<view :style='{"padding":"40rpx 80rpx","boxShadow":"0px 0px 0px #aaa","borderColor":"#e9be70","borderRadius":"40rpx","background":"none","borderWidth":"0px","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"40rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 20rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 24rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#b5eacb","color":"#333","borderRadius":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","borderWidth":"2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.username"  type="text"  class="uni-input" name="" placeholder="UserName" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 20rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 24rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#b5eacb","color":"#333","borderRadius":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","borderWidth":"2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.name"  type="text"  class="uni-input" name="" placeholder="Full Name" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 20rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 24rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#b5eacb","color":"#333","borderRadius":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","borderWidth":"2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.password" type="password"  class="uni-input" name="" placeholder="PassWord" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 20rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 24rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#b5eacb","color":"#333","borderRadius":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","borderWidth":"2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.password2" type="password" class="uni-input" name="" placeholder=" Confirm Password" />
			</view>
			<picker :style='{"boxShadow":"0px 0px 0px #2c77cb","margin":"20rpx 0 20rpx 0","borderColor":"#b5eacb","borderRadius":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","borderWidth":"2rpx","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghusexChange" :value="yonghusexIndex" :range="yonghusexOptions">
				<view :style='{"width":"100%","padding":"0 24rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#767676"}' class="uni-input">{{ruleForm.sex?ruleForm.sex:"Please select Gender"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 20rpx 0","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 24rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#b5eacb","color":"#333","borderRadius":"0px","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(245,253,248,1) 100%)","borderWidth":"2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.phone"  type="text"  class="uni-input" name="" placeholder="Phone" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 20rpx 0","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghuheadImageTap" class="">
                <view>Head Sculpture</view>
                <image :style='{"border":"0px solid #ccc","width":"200rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"120rpx"}' v-if="ruleForm.headImage" class="avator" :src="baseUrl+ruleForm.headImage" mode=""></image>
                <image :style='{"border":"0px solid #ccc","width":"200rpx","borderRadius":"0px","objectFit":"cover","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"padding":"0px","boxShadow":"0px 0px 0px #ccc","margin":"32rpx auto 204rpx","borderColor":"#b5eacb","color":"#333","display":"block","borderRadius":"0px","background":"linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(226,247,234,1) 100%)","borderWidth":"2rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">register</button>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghusexOptions: [],
                yonghusexIndex: 0,
				ruleForm: {
                username: '',
                name: '',
                password: '',
                sex: '',
                phone: '',
                headImage: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

			if(this.tableName=='yonghu'){
                this.yonghusexOptions = "男,女".split(',');
				this.ruleForm.sex=this.yonghusexOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            yonghusexChange(e) {
                    this.yonghusexIndex = e.target.value
                    this.ruleForm.sex = this.yonghusexOptions[this.yonghusexIndex]
            },
            yonghuheadImageTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.headImage = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			getUUID () {
				return new Date().getTime();
			},
			// register
			async register() {
				if((!this.ruleForm.username) && `yonghu` == this.tableName){
					this.$utils.msg(`UserName not null`);
					return
				}
				if((!this.ruleForm.name) && `yonghu` == this.tableName){
					this.$utils.msg(`Full Name not null`);
					return
				}
				if((!this.ruleForm.password) && `yonghu` == this.tableName){
					this.$utils.msg(`PassWord not null`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.password!=this.ruleForm.password2)){
                    this.$utils.msg(`The two password inputs are inconsistent`);
                    return
                }
				if(`yonghu` == this.tableName && this.ruleForm.phone&&(!this.$validate.isMobile(this.ruleForm.phone))){
					this.$utils.msg(`Phone`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('Registration successful');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
