using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace LibraryAPI.Migrations
{
    /// <inheritdoc />
    public partial class AddCurrentHolder : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "CurrentHolder",
                table: "Books");

            migrationBuilder.DropColumn(
                name: "Owner",
                table: "Books");

            migrationBuilder.AddColumn<int>(
                name: "CurrentHolderId",
                table: "Books",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Books_CurrentHolderId",
                table: "Books",
                column: "CurrentHolderId");

            migrationBuilder.AddForeignKey(
                name: "FK_Books_Users_CurrentHolderId",
                table: "Books",
                column: "CurrentHolderId",
                principalTable: "Users",
                principalColumn: "Id");

        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Books_Users_CurrentHolderId",
                table: "Books");

            migrationBuilder.DropForeignKey(
                name: "FK_Books_Users_OwnerUserId",
                table: "Books");

            migrationBuilder.DropIndex(
                name: "IX_Books_CurrentHolderId",
                table: "Books");

            migrationBuilder.DropIndex(
                name: "IX_Books_OwnerUserId",
                table: "Books");

            migrationBuilder.DropColumn(
                name: "CurrentHolderId",
                table: "Books");

            migrationBuilder.DropColumn(
                name: "OwnerUserId",
                table: "Books");

            migrationBuilder.AddColumn<string>(
                name: "CurrentHolder",
                table: "Books",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");

            migrationBuilder.AddColumn<string>(
                name: "Owner",
                table: "Books",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }
    }
}
