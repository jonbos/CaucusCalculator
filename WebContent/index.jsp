<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
<meta charset="UTF-8">
<title>Caucus Calculator</title>
<style>
	body{
		min-height: 100vh;
	}
</style>

</head>
<body class="has-background-grey-lighter">
	<section class="hero is-dark">
		<div class="hero-body">
			<div class="container">
				<h1 class="title">Caucus Calculator</h1>
			</div>
		</div>
	</section>
	<section>
		<div class="container">
			<div class="column is-three-fifths is-offset-one-fifth">
				<div class="box">
					<form method="post" action="GetCalculator">
						<label class="label">Number Of Viable Candidates</label>
						<div class="field has-addons">
							<div class="control is-expanded">
								<input name="numCandidates" class="input" type="text"
									placeholder="Candidates">
							</div>
							<p class="control">
								<button type="submit" class="button">Calculate</button>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>
</body>
</html>