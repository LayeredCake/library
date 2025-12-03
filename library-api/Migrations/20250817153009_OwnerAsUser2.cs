using Microsoft.EntityFrameworkCore.Migrations;
using System;

#nullable disable

namespace LibraryAPI.Migrations
{
    /// <inheritdoc />
    public partial class OwnerAsUser2 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "OwnerUserId",
                table: "Books",
                type: "int",
                nullable: true,
                defaultValue: 0);

            migrationBuilder.Sql("UPDATE [dbo].[Books] SET OwnerUserId = 1");

            migrationBuilder.AlterColumn<int>(
                name: "OwnerUserId",
                table: "Books",
                nullable: false);

            migrationBuilder.CreateIndex(
                name: "IX_Books_OwnerUserId",
                table: "Books",
                column: "OwnerUserId");

            migrationBuilder.AddForeignKey(
                name: "FK_Books_Users_OwnerUserId",
                table: "Books",
                column: "OwnerUserId",
                principalTable: "Users",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Books_Users_OwnerUserId",
                table: "Books");

            migrationBuilder.DropIndex(
                name: "IX_Books_OwnerUserId",
                table: "Books");

            migrationBuilder.DropColumn(
                name: "OwnerUserId",
                table: "Books");
        }
    }
}
