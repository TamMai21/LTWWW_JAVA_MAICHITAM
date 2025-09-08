<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Đăng Ký</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #87CEEB;
            margin: 0;
            padding: 20px;
            font-size: 12px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #87CEEB;
            padding: 20px;
            border-radius: 8px;
        }

        .form-row {
            display: flex;
            align-items: center;
            margin-bottom: 8px;
        }

        .form-label {
            width: 120px;
            text-align: left;
            font-weight: normal;
            color: #333;
        }

        .form-input {
            flex: 1;
            padding: 2px 5px;
            border: 1px solid #ccc;
            font-size: 12px;
            height: 18px;
        }

        .form-input-small {
            width: 40px;
            padding: 2px 5px;
            border: 1px solid #ccc;
            font-size: 12px;
            height: 18px;
            margin-right: 5px;
        }

        .date-inputs {
            display: flex;
            align-items: center;
            gap: 5px;
        }

        select {
            padding: 2px;
            border: 1px solid #ccc;
            font-size: 12px;
            height: 24px;
        }

        .gender-section {
            margin: 10px 0;
        }

        .textarea-large {
            width: 200px;
            height: 60px;
            padding: 5px;
            border: 1px solid #ccc;
            font-size: 12px;
            resize: vertical;
        }

        .checkbox-section {
            margin: 10px 0;
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
        }

        .checkbox-item {
            display: flex;
            align-items: center;
            gap: 5px;
        }

        .checkbox-item input[type="checkbox"] {
            margin: 0;
        }

        .table-section {
            margin: 15px 0;
            border: 2px solid #4169E1;
            padding: 10px;
            background-color: rgba(135, 206, 235, 0.3);
        }

        .table-section table {
            width: 100%;
            border-collapse: collapse;
        }

        .table-section th,
        .table-section td {
            border: 1px solid #ccc;
            padding: 4px;
            text-align: left;
            font-size: 11px;
        }

        .table-section th {
            background-color: #f0f0f0;
            font-weight: normal;
        }

        .table-section input {
            width: 100%;
            border: none;
            background: transparent;
            font-size: 11px;
            padding: 2px;
        }

        .radio-section {
            margin: 10px 0;
            display: flex;
            gap: 20px;
        }

        .radio-item {
            display: flex;
            align-items: center;
            gap: 5px;
        }

        .buttons {
            text-align: center;
            margin-top: 20px;
        }

        .btn {
            padding: 5px 15px;
            margin: 0 5px;
            font-size: 12px;
            border: 1px solid #666;
            background-color: #f0f0f0;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #e0e0e0;
        }

        .note-text {
            font-size: 10px;
            color: #666;
            margin-left: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="registration" method="post">
    <!-- First Name -->
        <div class="form-row">
            <label class="form-label">First name:</label>
            <input type="text" name="txtFName" class="form-input">
            <span class="note-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <!-- Last Name -->
        <div class="form-row">
            <label class="form-label">Last name:</label>
            <input type="text" name="txtLName" class="form-input">
            <span class="note-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <!-- Date of Birth -->
        <div class="form-row">
            <label class="form-label">Date of birth:</label>
            <div class="date-inputs">
                <select name="day">
                    <option value="">Day</option>
                    <% for(int i=1; i<=31; i++) { %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
                <select name="month">
                    <option value="">Month</option>
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <select name="year">
                    <option value="">Year</option>
                    <% for(int i=2024; i>=1950; i--) { %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
            </div>
        </div>

        <!-- Email -->
        <div class="form-row">
            <label class="form-label">Email:</label>
            <input type="email" name="txtEmail" class="form-input">
        </div>

        <!-- Mobile Number -->
        <div class="form-row">
            <label class="form-label">Mobile number:</label>
            <input type="text" name="txtMobileNumber" class="form-input">
            <span class="note-text">(10 digit number)</span>
        </div>

        <!-- Gender -->
        <div class="form-row">
            <label class="form-label">Gender:</label>
            <div class="gender-section">
                <label><input type="radio" name="gender" value="male"> Male</label>
                <label><input type="radio" name="gender" value="female"> Female</label>
            </div>
        </div>

        <!-- Address -->
        <div class="form-row">
            <label class="form-label">Address:</label>
            <textarea name="txtAddress" class="textarea-large"></textarea>
        </div>

        <!-- City -->
        <div class="form-row">
            <label class="form-label">City:</label>
            <input type="text" name="txtCity" class="form-input">
            <span class="note-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <!-- Pin Code -->
        <div class="form-row">
            <label class="form-label">Pin code:</label>
            <input type="text" name="txtPinCode" class="form-input">
            <span class="note-text">(6 digit number)</span>
        </div>

        <!-- State -->
        <div class="form-row">
            <label class="form-label">State:</label>
            <input type="text" name="txtState" class="form-input">
            <span class="note-text">(max 30 characters a-z and A-Z)</span>
        </div>

        <!-- Country -->
        <div class="form-row">
            <label class="form-label">Country:</label>
            <select name="txtCountry" class="form-input">
                <option value="India">India</option>
                <option value="USA">USA</option>
                <option value="UK">UK</option>
                <option value="Canada">Canada</option>
                <option value="Australia">Australia</option>
            </select>
        </div>

        <!-- Hobbies -->
        <div class="form-row">
            <label class="form-label">Hobbies:</label>
            <div class="checkbox-section">
                <div class="checkbox-item">
                    <input type="checkbox" name="chkHobbies" value="drawing" id="drawing">
                    <label for="drawing">Drawing</label>
                </div>
                <div class="checkbox-item">
                    <input type="checkbox" name="chkHobbies" value="singing" id="singing">
                    <label for="singing">Singing</label>
                </div>
                <div class="checkbox-item">
                    <input type="checkbox" name="chkHobbies" value="dancing" id="dancing">
                    <label for="dancing">Dancing</label>
                </div>
                <div class="checkbox-item">
                    <input type="checkbox" name="chkHobbies" value="sketching" id="sketching">
                    <label for="sketching">Sketching</label>
                </div>
                <div class="checkbox-item">
                    <input type="checkbox" name="chkHobbies" value="others" id="others">
                    <label for="others">Others</label>
                    <input type="text" name="chkHobbies" placeholder="Specify">
                </div>
            </div>
        </div>

        <!-- Qualification Table -->
        <div class="table-section">
            <table>
                <thead>
                <tr>
                    <th>Qualification</th>
                    <th>Slno</th>
                    <th>Examination</th>
                    <th>Board</th>
                    <th>Percentage</th>
                    <th>Year of passing</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Class X</td>
                    <td><input type="text" name="class10_slno"></td>
                    <td><input type="text" name="class10_exam"></td>
                    <td><input type="text" name="class10_board"></td>
                    <td><input type="text" name="class10_percentage"></td>
                    <td><input type="text" name="class10_year"></td>
                </tr>
                <tr>
                    <td>Class XII</td>
                    <td><input type="text" name="class12_slno"></td>
                    <td><input type="text" name="class12_exam"></td>
                    <td><input type="text" name="class12_board"></td>
                    <td><input type="text" name="class12_percentage"></td>
                    <td><input type="text" name="class12_year"></td>
                </tr>
                <tr>
                    <td>Graduation</td>
                    <td><input type="text" name="graduation_slno"></td>
                    <td><input type="text" name="graduation_exam"></td>
                    <td><input type="text" name="graduation_board"></td>
                    <td><input type="text" name="graduation_percentage"></td>
                    <td><input type="text" name="graduation_year"></td>
                </tr>
                <tr>
                    <td>Masters</td>
                    <td><input type="text" name="masters_slno"></td>
                    <td><input type="text" name="masters_exam"></td>
                    <td><input type="text" name="masters_board"></td>
                    <td><input type="text" name="masters_percentage"></td>
                    <td><input type="text" name="masters_year"></td>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- Courses Applied For -->
        <div class="form-row">
            <label class="form-label">Courses applied for:</label>
            <div class="radio-section">
                <div class="radio-item">
                    <input type="radio" name="rdCourse" value="bca" id="bca">
                    <label for="bca">BCA</label>
                </div>
                <div class="radio-item">
                    <input type="radio" name="rdCourse" value="bcom" id="bcom">
                    <label for="bcom">B.Com</label>
                </div>
                <div class="radio-item">
                    <input type="radio" name="rdCourse" value="bsc" id="bsc">
                    <label for="bsc">B.Sc</label>
                </div>
                <div class="radio-item">
                    <input type="radio" name="rdCourse" value="ba" id="ba">
                    <label for="ba">BA</label>
                </div>
            </div>
        </div>

        <!-- Buttons -->
        <div class="buttons">
            <input type="submit" value="Submit" class="btn">
            <input type="reset" value="Reset" class="btn">
        </div>

    </form>
</div>
</body>
</html>