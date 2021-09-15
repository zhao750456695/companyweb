const headerEL = document.querySelector("header");
const scrollToTop = document.querySelector(".scrollToTop");
window.addEventListener("scroll", () => {
    let height = headerEL.getBoundingClientRect().height;

    if (window.pageYOffset - height > 800) {
        if (!headerEL.classList.contains("sticky")) {
            headerEL.classList.add("sticky");
        }
    } else {
        headerEL.classList.remove("sticky");
    }

    if (window.pageYOffset > 2000) {
        scrollToTop.style.display = "block";
    } else {
        scrollToTop.style.display = "none";
    }
});



// 折叠按钮
const burgerEL = document.querySelector(".burger");
burgerEL.addEventListener("click", () => {
    headerEL.classList.toggle("open");
});
