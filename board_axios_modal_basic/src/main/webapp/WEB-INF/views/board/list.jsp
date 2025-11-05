<%--
    list.jsp에서 테이블로 목록 출력

   각 행에 “수정” 버튼 → 클릭 시 모달 열고, Axios GET으로 JSON 받아와 폼 채운다.

   모달에서 “저장” 버튼 → 새 글이면 POST, 기존글이면 PUT

    삭제 버튼 → DELETE 요청
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>게시판 목록</title>

	<!-- Bootstrap CSS  -->
	<link rel="stylesheet"
	      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>

	<!-- Axios (CDN방식 라이브러리 적용) -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</head>
<body class="container py-4">

<h1>게시판</h1>

<button class="btn btn-primary mb-3" onclick="openCreateModal()">새 글 작성</button>

<table class="table table-bordered table-hover">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>관리</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.bno}</td>
			<td>${board.title}</td>
			<td>${board.writer}</td>
			<td>${board.regDate}</td>
			<td>
				<button class="btn btn-sm btn-secondary"
				        onclick="openEditModal(${board.bno})">수정
				</button>
				<button class="btn btn-sm btn-danger"
				        onclick="deleteBoard(${board.bno})">삭제
				</button>
			</td>
		</tr>
	</c:forEach>

	</tbody>
</table>

<!-- 모달-->
<div class="modal fade" id="boardModal" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="boardModalLabel">글 작성/수정</h5>
				<button type="button" class="btn-close"
				        data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">

				<input type="hidden" id="bno"/>

				<div class="mb-3">
					<label class="form-label">제목</label>
					<input type="text" id="title" class="form-control"/>
				</div>

				<div class="mb-3">
					<label class="form-label">내용</label>
					<textarea id="content" class="form-control" rows="4"></textarea>
				</div>

				<div class="mb-3">
					<label class="form-label">작성자</label>
					<input type="text" id="writer" class="form-control"/>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button"
				        class="btn btn-secondary"
				        data-bs-dismiss="modal">닫기
				</button>
				<button type="button"
				        class="btn btn-primary"
				        onclick="saveBoard()">저장
				</button>
			</div>
		</div>
	</div>
</div>

<!-- 모달 작동 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">


  // 새 글 작성 모달 열기
  // 모달 DOM 요소를 가져와서 Bootstrap Modal 객체 생성
  const modalElement = document.getElementById('boardModal');
  const modal = new bootstrap.Modal(modalElement);

  /**
   * 폼 내용을 초기화하는 함수
   * - 숨겨진 bno, 제목, 내용, 작성자 입력값을 모두 비운다.
   * - 주로 새 글 작성 시작할 때나 수정 모달 열기 전에 호출.
   */
  function clearForm() {
    document.getElementById('bno').value = '';
    document.getElementById('title').value = '';
    document.getElementById('content').value = '';
    document.getElementById('writer').value = '';
  }

  /**
   * "새 글 작성" 버튼 클릭 시 호출되는 함수.
   * - 기존에 입력되어 있을지도 모르는 값들을 모두 지우고(clearForm),
   * - 작성자 입력창을 수정 가능 상태로 만들고(readonly 제거),
   * - 모달 제목을 "새 글 작성"으로 바꾸고,
   * - 모달을 화면에 보여준다.
   */
  function openCreateModal() {
    clearForm();
    document.getElementById('writer').removeAttribute('readonly');
    document.getElementById('boardModalLabel').innerText = '새 글 작성';
    modal.show();
  }

  /**
   * "수정" 버튼 클릭 시 호출되는 함수.
   * - 먼저 폼을 초기화한 뒤,
   * - /api/board/{bno} 로 GET 요청을 보내서 해당 글 정보를 JSON으로 받아온다.
   * - 응답 데이터(data)를 각 input/textarea에 채워 넣는다.
   * - 수정일 때는 작성자를 못 바꾸게 readonly로 설정한다.
   * - 마지막에 모달을 띄운다.
   *
   * @param bno 수정할 글 번호
   */
  function openEditModal(bno) {
    clearForm();
    document.getElementById('boardModalLabel').innerText = '글 수정';
    axios.get('/api/board/' + bno).then(
        function (response) {
          const data = response.data; // 서버에서 넘긴 BoardVO JSON

          if (!data) {
            alert('글을 찾을 수 없습니다.')
            return
          }

          document.getElementById('bno').value = data.bno;
          document.getElementById('title').value = data.title;
          document.getElementById('content').value = data.content;
          document.getElementById('writer').value = data.writer;

          // 수정 시 작성자 못바꾸게 읽기 전용 속성으로 변경
          document.getElementById('writer').setAttribute('readonly', 'readonly');
          modal.show();

        }).catch(
        function (error) {
          console.error(error);
          alert('글 수정을 진행하는 도중 오류가 생겼습니다.');
        }
    )
  }

  // 저장 버튼 (새 글인지 수정인지 구분)
  function saveBoard() {
    const bno = document.getElementById('bno').value;
    const title = document.getElementById('title').value;
    const content = document.getElementById('content').value;
    const writer = document.getElementById('writer').value;

    const payLoad = {
      title: title,
      content: content,
      writer: writer
    };

    if (!bno) { // 저장 버튼 클릭 시 새글이면 POST, 수정이면 PUT
      axios.post('/api/board', payLoad)
      .then(
          function (response) {
            alert("등록 완료")
            // 새 글이 추가되었으니 전체 목록을 새로고침
            location.reload();
          }
      ).catch(
          function (error) {
            console.log(error)
            alert('등록 실패')
          }
      );
    } else {
      axios.put('/api/board/' + bno, payLoad)
      .then(
          function (response) {
            alert('수정 완료!');
            // 수정 후 변경 내용 반영을 위해 목록 새로고침
            location.reload();
          }
      ).catch(function (error) {
        alert('수정 중 오류가 발생했습니다.');
        console.log(error);
      })
    }

  }

  // 새 글 작성(POST) vs 수정(PUT) 구분
  function deleteBoard(bno) {
    if (!confirm('정말 삭제하시겠습니다?')) return;

    axios.delete('/api/board/' + bno).then(
        function (response) {
          alert('삭제 완료!');
          location.reload();
        }).catch(
        function (error) {
          console.error(error);
          alert('삭제 실패')
        }
    )
  }

  // PUT /api/board/{bno}

  // 삭제

</script>

</body>
</html>

