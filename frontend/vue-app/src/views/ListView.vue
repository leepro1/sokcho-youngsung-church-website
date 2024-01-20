<template>
    <div class="container mt-3">
          <h1 class="display-1 text-center">회원 목록</h1>
          <div class="btn-group">
            <a href="/member/save" class="btn btn-primary">회원 추가</a>
          </div>
          <table class="table table-hover mt-3">
            <thead class="table-dark">
              <tr>
                <th>이름</th>
                <th>이메일</th>
                <th>성별</th>
                <th>등록여부</th>
                <th>가입일</th>
              </tr>
            </thead>
            <tbody>
              <tr class="cursor-pointer" onclick="location.href = '/member/findById';">
                <td>스티븐</td>
                <td>jobs@shellfolder.com</td>
                <td>남자</td>
                <td>O</td>
                <td>2023-02-28</td>
              </tr>
              <tr class="cursor-pointer" onclick="location.href = '/member/findById';">
                <td>에브릴</td>
                <td>lavigne@shellfolder.com</td>
                <td>여자</td>
                <td>X</td>
                <td>2023-02-27</td>
              </tr>
            </tbody>
          </table>
        </div>
    </template>
    
    <script>
    </script>
    <style scoped>
    tbody > tr {
        cursor: pointer;
    }
    </style>