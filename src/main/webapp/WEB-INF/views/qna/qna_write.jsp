<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<!-- Mirrored from www.hellomarket.com/help/inquiry/form.hm by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 23 Feb 2022 13:21:35 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8"/><!-- /Added by HTTrack -->
<head>
   	<style type="text/css">
   	
   	#text1_field{
   	height:150px;
   	}
   	
   	#photo_field{
   	height:200px;
   	}
   	#agree_field{
   	height:250px;
	}   	
	#qnabtn5{
	background-color: #00a000;
	}
   	</style>
</head>
<body>
    <section class="content"><h1>헬로마켓 - 100% 비대면 안전 결제 중고거래 마켓</h1>
        <h2>공지사항 리스트</h2>
        <div class="item_list_min">
            <div class="item_list_area inquiery_list_area">
                <div class="breadcrumbs">
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/index.jsp">HOME</a></li>
                    </ul>
                </div>
                <div class="main_area">
                    <div class="main_area_center">
                        <div class="main">
                            <div class="left">
                                <div class="left_nav_type2">
                                    <div class="left_nav_type2_title">헬프센터</div>
                                    <ul class="left_nav_menu">
                                        <li><a href="<%=request.getContextPath()%>/index.jsp?workgroup=notice&work=notice_list"><span>공지사항</span></a></li>
										<li><a href="<%=request.getContextPath()%>/index.jsp?workgroup=faq&work=faq_list"><span>FAQ</span></a></li>
										<li><a class="active" id="scrollMain" href="<%=request.getContextPath()%>/index.jsp?workgroup=qna&work=qna_list"><span>QnA</span></a></li>
                                    </ul>
                                </div>
                            </div>
                            <section class="left_main">

                                <div class="mail_view"><h1>헬로마켓 - 100% 비대면 안전 결제 중고거래 마켓</h1>
                                    <h2>일반문의 신청 페이지</h2>
                                    <form enctype="multipart/form-data">
                                        <table class="inquiry_table">
                                            <tbody>
                                            <tr>
                                                <td class="label">*이름</td>
                                                <td class="field"><input type="text" class="" placeholder="이름을 입력해주세요."
                                                                         value=""/></td>
                                            </tr>
                                            <tr>
                                                <td class="label">*연락처</td>
                                                <td class="field"><input type="text" class=""
                                                                         placeholder="연락처를 입력해주세요.(숫자만)" value=""/></td>
                                            </tr>
                                            <tr>
                                                <td class="label">*이메일</td>
                                                <td class="field"><input type="text" class="" placeholder="이메일을 입력해주세요."
                                                                         value=""/></td>
                                            </tr>
                                            <tr>
                                                <td class="label">*유형</td>
                                                <td class="field"><select id="" class="commonSelectbox">
                                                    <option selected="" value="1" disabled="">카테고리 선택</option>
                                                    <option selected="" value="2" disabled="">카테고리 선택</option>
                                                </select></td>
                                            </tr>
                                            <tr>
                                                <td class="label">*하위 유형</td>
                                                <td class="field"><select id="" class="commonSelectbox">
                                                    <option selected="" value="" disabled="">카테고리 선택</option>
                                                </select></td>
                                            </tr>
                                            <tr>
                                                <td class="label">*제목</td>
                                                <td class="field"><input type="text" class="" placeholder="제목을 입력해주세요."
                                                                         value=""/></td>
                                            </tr>
                                            <tr>
                                                <td class="field photo_field" colSpan="2" id="text1_field"><textarea placeholder="내용 입력"
                                                                                                    class="textarea"
                                                                                                    rows="7"></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="field photo_field" colSpan="2" id="photo_field" ><label>사진첨부</label>
                                                    <div class="inquiry_photo_wrapper">
                                                        <ul class="image_list">
                                                            <input type="file" multiple="" class="multiple"/>
                                                          <!--  <li>
                                                                <input id="file-input" type="file" style="display: none" />
                                                                <div class="up_img_box">
                                                                    <img src="../../../ccimage.hellomarket.com/web/2018/auto/img_car_pic_basic.png"
                                                                         class="item_img" alt="상품 등록 이미지" id="preview"/></div>
                                                            </li>-->
                                                            <li>
                                                                <input id="file-input" type="file" style="display: none" />
                                                                    <label for="file-input" >
                                                                        <img src="<%=request.getContextPath()%>/img/site/cam.png" id ="preview" for="file-input" />
                                                                    </label>

                                                             </li>
                                                            <li>
                                                                <input id="file-input1" type="file" style="display: none" />
                                                                <label for="file-input1" >
                                                                    <img src="<%=request.getContextPath()%>/img/site/cam.png" id ="preview1" for="file-input1" />
                                                                </label>

                                                            </li>
                                                            <li>
                                                                <input id="file-input2" type="file" style="display: none" />
                                                                <label for="file-input2" >
                                                                    <img src="<%=request.getContextPath()%>/img/site/cam.png" id ="preview2" for="file-input2" />
                                                                </label>

                                                            </li>

                                                        </ul>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="label agree_label">약관동의</td>
                                                <td class="field" id="agree_field">
                                                    <div class="field_agree" >
                                                        <label class="feature_option feature_option_checkbox" id ="agreetest">개인정보처리방침 동의
                                                            <div class="feature_option_checkbox_indicator" id="agreeindi"></div>
                                                         </label>

                                                        <div class="field_notice_box">
                                                            <div>주)헬로마켓은 이용자님께서 문의한 내용을 통해 소비자 불만 또는 분쟁, 제휴상담을 처리하고자
                                                                최소한의 범위 내에서 아래와 같이 개인정보를 수집·이용합니다.<br/><br/>- 수집이용·목적 :
                                                                문의하기<br/>- 수집항목 : 이름, 휴대폰번호, 이메일 주소<br/>- 보유·이용기간 :
                                                                전자상거래 등에서의 소비자보호에 관한 법률에 따라 3년<br/></div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                    <ul class="btn_wrapper btn_wrapper_center" >
                                        <li>
                                            <div class="btn" id = "qnabtn5">문의하기</div>
                                        </li>
                                    </ul>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>


  <script type="text/javascript">
  document.getElementById("agreetest").onclick= function (){
      document.getElementById("agreeindi").classList.toggle('checked');
  }





  document.getElementById('file-input').onchange=function(){

      setImageFromFile(this, 'preview')

  };

  function setImageFromFile(input, expression) {

      if (input.files && input.files[0])
      {


          const reader1 = new FileReader();

          reader1.onload = function (e) {

              document.getElementById(expression).setAttribute('src', e.target.result.toString());
          }
          reader1.readAsDataURL(input.files[0]);
      }
  }
//////
  document.getElementById('file-input1').onchange=function(){

      setImageFromFile1(this, 'preview1')

  };

  function setImageFromFile1(input, expression) {

      if (input.files && input.files[0])
      {


          const reader1 = new FileReader();

          reader1.onload = function (e) {

              document.getElementById(expression).setAttribute('src', e.target.result.toString());
          }
          reader1.readAsDataURL(input.files[0]);
      }
  }
  //
  document.getElementById('file-input2').onchange=function(){

      setImageFromFile2(this, 'preview2')

  };

  function setImageFromFile2(input, expression) {

      if (input.files && input.files[0])
      {


          const reader1 = new FileReader();

          reader1.onload = function (e) {

              document.getElementById(expression).setAttribute('src', e.target.result.toString());
          }
          reader1.readAsDataURL(input.files[0]);
      }
  }
  </script>
</body>