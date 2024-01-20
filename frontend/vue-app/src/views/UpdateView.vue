<template>
	<div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 수정</h1>
		<form>
		  <div class="mb-3 mt-3">
		    <label for="name" class="form-label">이름:</label>
		    <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" readonly>
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="email" class="form-label">이메일:</label>
		    <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" readonly>
		  </div>
		  <div class="mb-3">
		    <label for="pwd" class="form-label">비밀번호:</label>
		    <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd">
		  </div>
          <div class="d-flex">
                        성별 : 
                  <div class="p-2 flex-fill">
                      <div class="form-check">
                        <input type="radio" class="form-check-input" id="maleRadio" name="sex" value="1" checked>남성
                        <label class="form-check-label" for="maleRadio1"></label>
                    </div>
                  </div>
                  <div class="p-2 flex-fill">
                      <div class="form-check">
                        <input type="radio" class="form-check-input" id="FemaleRadio" name="sex" value="2">여성
                        <label class="form-check-label" for="FemaleRadio"></label>
                    </div>
                  </div>
                </div>
                <div class="d-flex">
                    등록 교인 입니까? : 
                  <div class="p-2 flex-fill">
                      <div class="form-check">
                        <input type="radio" class="form-check-input" id="churchMemberRadio1" name="isChurchMember" value="1" checked>예
                        <label class="form-check-label" for="churchMemberRadio1"></label>
                    </div>
                  </div>
                  <div class="p-2 flex-fill">
                      <div class="form-check">
                        <input type="radio" class="form-check-input" id="churchMemberRadio2" name="isChurchMember" value="2"> 아니오
                        <label class="form-check-label" for="churchMemberRadio2"></label>
                    </div>
                  </div>
			</div>
		</form>
		<div class="d-flex">
		  <div class="p-2 flex-fill d-grid">
				<a href="/member/findById" class="btn btn-primary">저장</a>
		  </div>
		  <div class="p-2 flex-fill d-grid">
			<a href="/member/findById" class="btn btn-primary">취소</a>
		  </div>
		</div>
	</div>
</template>