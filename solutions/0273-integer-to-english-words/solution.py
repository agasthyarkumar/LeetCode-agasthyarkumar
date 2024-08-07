class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                    "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]
        
        def helper(n):
            if n == 0:
                return ""
            elif n < 20:
                return below_20[n] + " "
            elif n < 100:
                return tens[n // 10] + " " + helper(n % 10)
            elif n < 1000:
                return below_20[n // 100] + " Hundred " + helper(n % 100)
            else:
                for i, word in enumerate(thousands):
                    if n < 1000 ** (i + 1):
                        return helper(n // (1000 ** i)) + word + " " + helper(n % (1000 ** i))
        
        return helper(num).strip()
