using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace LibraryAPI.Migrations
{
    /// <inheritdoc />
    public partial class RenameOwner : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Books_Users_OwnerUserId",
                table: "Books");

            migrationBuilder.RenameColumn(
                name: "OwnerUserId",
                table: "Books",
                newName: "OwnerId");

            migrationBuilder.RenameIndex(
                name: "IX_Books_OwnerUserId",
                table: "Books",
                newName: "IX_Books_OwnerId");

            migrationBuilder.AddForeignKey(
                name: "FK_Books_Users_OwnerId",
                table: "Books",
                column: "OwnerId",
                principalTable: "Users",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Books_Users_OwnerId",
                table: "Books");

            migrationBuilder.RenameColumn(
                name: "OwnerId",
                table: "Books",
                newName: "OwnerUserId");

            migrationBuilder.RenameIndex(
                name: "IX_Books_OwnerId",
                table: "Books",
                newName: "IX_Books_OwnerUserId");

            migrationBuilder.AddForeignKey(
                name: "FK_Books_Users_OwnerUserId",
                table: "Books",
                column: "OwnerUserId",
                principalTable: "Users",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
